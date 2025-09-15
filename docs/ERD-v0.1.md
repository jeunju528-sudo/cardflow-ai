[User]
- id (PK)
- username
- email

[Transaction]
- id (PK)
- user_id (FK → User.id)
- amount
- currency
- country
- channel
- status (APPROVED/DECLINED)
- tx_datetime
- merchant

[AI_Report] (Optional, 생성 기록 저장)
- id (PK)
- generated_at
- period_start
- period_end
- summary
