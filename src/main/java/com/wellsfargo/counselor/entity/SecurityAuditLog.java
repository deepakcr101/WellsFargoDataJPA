package com.wellsfargo.counselor.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "security_audit_logs")
public class SecurityAuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auditId;

    @ManyToOne
    @JoinColumn(name = "security_id", nullable = false)
    private Security security;

    @ManyToOne
    @JoinColumn(name = "advisor_id", nullable = false)
    private FinancialAdvisor advisor;

    @Column(nullable = false)
    private String actionType;  // CREATE, UPDATE, DELETE

    private LocalDateTime actionTimestamp;

    @Lob
    private String details;

    // constructor
    public SecurityAuditLog(Security security, FinancialAdvisor advisor, String actionType,
                            LocalDateTime actionTimestamp, String details) {
        this.security = security;
        this.advisor = advisor;
        this.actionType = actionType;
        this.actionTimestamp = actionTimestamp;
        this.details = details;
    }

    public SecurityAuditLog() {}

    // getters & setters
    public Long getAuditId() { return auditId; }
    public Security getSecurity() { return security; }
    public void setSecurity(Security security) { this.security = security; }
    public FinancialAdvisor getAdvisor() { return advisor; }
    public void setAdvisor(FinancialAdvisor advisor) { this.advisor = advisor; }
    public String getActionType() { return actionType; }
    public void setActionType(String actionType) { this.actionType = actionType; }
    public LocalDateTime getActionTimestamp() { return actionTimestamp; }
    public void setActionTimestamp(LocalDateTime actionTimestamp) { this.actionTimestamp = actionTimestamp; }
    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }
}

