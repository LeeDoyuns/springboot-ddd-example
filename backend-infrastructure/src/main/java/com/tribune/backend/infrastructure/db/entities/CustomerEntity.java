package com.tribune.backend.infrastructure.db.entities;


import com.tribune.backend.domain.element.customer.CustomerState;
import com.tribune.backend.domain.element.customer.CustomerType;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name ="CUSTOMER")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String displayName;

    private String firstName;

    private String lastName;

    @Enumerated(value = EnumType.STRING)
    private CustomerState state;

    @Enumerated(value = EnumType.STRING)
    private CustomerType type;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<PaymentEntity> paymentEntityList;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<AddressEntity> addressEntityList;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<InvoiceEntity> invoiceEntityList;

    @CreationTimestamp
    @Column(name = "CREATION_TIMESTAMP",nullable = false,updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime creationTimestamp;

    @UpdateTimestamp
    @Column(name = "UPDATE_TIMESTAMP",nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updateTimestamp;
}
