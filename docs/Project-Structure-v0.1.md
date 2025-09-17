# 프로젝트 구조
src/main/java/com/cardflow/finance/
├─ CardflowAiApplication.java        # 메인 클래스 (Spring Boot 시작점)
│                                     # @SpringBootApplication + @MapperScan 붙여서
│                                     # 전체 애플리케이션 구동 담당
│
├─ domain/                           # 데이터 모델/DTO 모음
│    ├─ Transaction.java              # 거래 엔티티 (DB 테이블과 매핑)
│    └─ TransactionFilterRequest.java # 거래 조회 요청 DTO (검색조건/페이징)
│
├─ mapper/                           # MyBatis 매퍼 인터페이스
│    └─ TransactionMapper.java        # Transaction 관련 CRUD/조회 정의
│
├─ service/                          # 비즈니스 로직 계층
│    ├─ TransactionService.java       # 거래 조회 서비스 인터페이스
│    ├─ UploadService.java            # 업로드 서비스 인터페이스
│    └─ impl/                         # 실제 구현체
│         ├─ TransactionServiceImpl.java
│         └─ UploadServiceImpl.java
│
└─ controller/                       # 웹 계층 (API & View Controller)
├─ TransactionController.java    # /api/transactions (REST API)
├─ UploadController.java         # /api/upload (REST API)
└─ PageController.java           # JSP 화면 라우팅 ("/", "/upload", "/transactions")

# 리소스 구조
src/main/resources/
├─ application.yml                    # 공통 설정 (profiles active 등)
├─ application-dev.yml                # dev 환경 설정 (DB 연결, 로그레벨 등)
├─ application-prd.yml                # prd 환경 설정 (운영 DB, 보안설정)
│
├─ mappers/                           # MyBatis 매퍼 XML
│    └─ TransactionMapper.xml
│
├─ schema.sql                         # 초기 테이블 생성 스크립트
│
└─ messages_ko.properties             # 검증/예외 메시지 (한글화)


# 웹
src/main/webapp/WEB-INF/jsp/
├─ layout.jsp                         # 공통 레이아웃 (헤더/네비게이션)
├─ dashboard.jsp                      # 대시보드 (리포트 뷰)
├─ upload.jsp                         # CSV 업로드 화면
└─ transactions.jsp                    # 거래 조회 화면

# 기타
docker-compose.yml                     # MySQL 컨테이너 설정
pom.xml                                # Maven 의존성 관리
docs/                                  # 기획서, 명세서 등 문서 
samples/                               # 샘플 CSV 등 테스트 데이터
mysql-data/                            # MySQL 로컬 데이터 볼륨
