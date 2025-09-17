package com.cardflow.finance.domain;


import java.math.BigDecimal;
import java.time.LocalDateTime;


public class Transaction {
    private Long id;
    private Long userId;
    private BigDecimal amount;
    private String currency; // ISO 4217
    private String country; // ISO 3166-1 alpha-2
    private String channel; // WEB/APP/POS/CALL
    private String status; // APPROVED/DECLINED/PENDING
    private LocalDateTime txDatetime;
    private String merchant;


    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public String getChannel() { return channel; }
    public void setChannel(String channel) { this.channel = channel; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getTxDatetime() { return txDatetime; }
    public void setTxDatetime(LocalDateTime txDatetime) { this.txDatetime = txDatetime; }
    public String getMerchant() { return merchant; }
    public void setMerchant(String merchant) { this.merchant = merchant; }
}