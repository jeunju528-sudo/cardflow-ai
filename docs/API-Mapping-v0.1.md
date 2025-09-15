# UI ↔ REST API Mapping v0.1

## API 명세
- POST /api/auth/register : 사용자 등록
- POST /api/auth/login : 로그인 → JWT 발급
- POST /api/import/transactions : CSV 업로드 → 배치 실행
- GET /api/import/{jobId}/status : 배치 진행 상태 조회
- GET /api/tx : 거래 목록 조회 (필터/페이징)
- GET /api/stats/approval : 승인율/거절율 통계
- GET /api/stats/errors : 에러코드/가맹점 TOP N
- GET /api/stats/perf : 지연 시간 통계
- POST /api/ai/insight : AI 인사이트 생성


## 공통
- Auth: Authorization: Bearer <JWT>
- Error 포맷: {timestamp, path, status, code, message, details}

## Login.jsp
| 액션 | METHOD | URL              | Request 예시                              | 성공(200)              | 실패 |
|-----|--------|------------------|-------------------------------------------|------------------------|------|
| 로그인 | POST   | /api/auth/login  | {"email":"a@b.com","password":"****"}     | {"accessToken":"..."}  | 401 INVALID_CREDENTIALS |

## Upload.jsp
| 액션      | METHOD | URL                          | Request 예시                | 성공(202)                               | 실패 |
|----------|--------|------------------------------|-----------------------------|-----------------------------------------|------|
| CSV 업로드 | POST   | /api/import/transactions     | multipart/form-data(file)   | {"jobId":123,"status":"STARTED"}        | 400 INVALID_CSV, 413 FILE_TOO_LARGE |
| 상태조회   | GET    | /api/import/{jobId}/status   | (path: jobId)               | {"status":"COMPLETED","total":100000,...}| 404 JOB_NOT_FOUND |

## Dashboard.jsp (기간 from/to 필수)
| 액션          | METHOD | URL                  | Query/Body 예시                                                                 | 성공(200)                             | 실패 |
|--------------|--------|----------------------|----------------------------------------------------------------------------------|---------------------------------------|------|
| 거래목록 조회   | GET    | /api/tx              | from=2025-07-01&to=2025-07-31&country=KR&channel=APP&page=0&size=50              | Page<{id,ts,amount,...}>              | 400 MISSING_FROM/TO |
| 승인율 통계    | GET    | /api/stats/approval  | from=...&to=...&groupBy=day                                                      | {"total":...,"byGroup":[...]}         | 400 INVALID_GROUPBY |
| 에러 TOP N    | GET    | /api/stats/errors    | from=...&to=...&top=merchant&limit=10                                            | {"items":[{"key":"M88990","declined":123}]} | - |
| 지연 통계     | GET    | /api/stats/perf      | from=...&to=...&p95=true                                                         | {"avgLatencyMs":210,"p95LatencyMs":980}| - |
| AI 리포트     | POST   | /api/ai/insight      | {"from":"2025-07-01","to":"2025-07-31"}                                          | {"summary":"...","advice":[...],"risk":[...]} | 429 AI_RATE_LIMIT |
