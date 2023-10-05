package com.example.telcosystemservice.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Builder
@Table(name = "user_package_activation")
public class UserPackageActivation {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Getter
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Getter
    @ManyToOne
    @JoinColumn(name = "package_id", nullable = false)
    private TelcoPackage telcoPackage;

    @Getter
    @Column(name = "activated_dt", nullable = false)
    private Timestamp activatedDateTime;

    @Getter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Getter
    @Column(name = "remaining", nullable = false)
    private Integer remaining;

    public UserPackageActivation(UUID id, User user, TelcoPackage telcoPackage, Timestamp activatedDateTime, Status status, Integer remaining) {
        this.id = id;
        this.user = user;
        this.telcoPackage = telcoPackage;
        this.activatedDateTime = activatedDateTime;
        this.status = status;
        this.remaining = telcoPackage.getSize();
    }

    public UserPackageActivation() {

    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setRemaining(Integer remaining) {
        this.remaining = remaining;
    }
}
