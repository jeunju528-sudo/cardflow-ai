# CardFlow AI — Functional Spec v0.1

## 1. 프로젝트 개요
CardFlow AI는 대용량 카드 거래 로그(CSV)를 업로드하고,
Spring Batch로 DB에 적재한 뒤 REST API를 통해 조회/통계를 제공한다.
추가적으로 생성형 AI를 활용해 요약/개선 권고/리스크 리포트를 자동 생성한다.

## 2. 기능 목록
### MVP
- 회원가입/로그인 (JWT)
- CSV 업로드 → 배치 적재
- 거래 조회 (기간/국가/채널/가맹점/코드별 필터)
- 통계 조회 (승인율/거절율, 에러 TOP N, p95 지연)
- AI 인사이트 생성 (요약/권고/리스크)
- JSP+jQuery 웹 UI (로그인, 업로드, 대시보드)

### 확장
- 이상 거래 탐지 (야간 고액, 특정 국가 급증)
- 관리자 권한 기능 (사용자 관리)
- 데이터 Export (CSV, Excel)

## 3. 유스케이스
1) 사용자가 로그인한다.
2) CSV 파일을 업로드한다.
3) 시스템이 배치 잡을 실행해 데이터를 DB에 저장한다.
4) 사용자는 진행 상태를 확인한다.
5) 사용자는 대시보드에서 거래 목록과 통계를 조회한다.
6) "AI 인사이트 생성" 버튼을 눌러 요약 리포트를 확인한다.

## 4. 화면 정의
- Login.jsp : 사용자 로그인 (JWT 토큰 발급)
- Upload.jsp : CSV 업로드 + 진행 상태 확인
- Dashboard.jsp : 거래 목록(필터/페이징), 통계(표/차트), AI 리포트 패널

## 5. API 명세
- POST /api/auth/register : 사용자 등록
- POST /api/auth/login : 로그인 → JWT 발급
- POST /api/import/transactions : CSV 업로드 → 배치 실행
- GET /api/import/{jobId}/status : 배치 진행 상태 조회
- GET /api/tx : 거래 목록 조회 (필터/페이징)
- GET /api/stats/approval : 승인율/거절율 통계
- GET /api/stats/errors : 에러코드/가맹점 TOP N
- GET /api/stats/perf : 지연 시간 통계
- POST /api/ai/insight : AI 인사이트 생성

## 6. DB 테이블 설계
### users
- id (bigserial, PK)
- email (varchar, unique)
- password_hash (varchar)
- created_at (timestamptz)

### card_transactions
- id (bigserial, PK)
- user_id (bigint, FK → users.id)
- tx_timestamp (timestamptz, not null)
- amount (numeric(18,2), not null)
- currency (char(3), not null)
- country (char(2), not null)
- channel (varchar(20), not null)
- merchant_id (varchar(64), not null)
- result_code (varchar(10), not null)
- latency_ms (int)
- created_at (timestamptz, default now())

