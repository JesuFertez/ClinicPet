package com.coworkers.clinicpet.model.entities;import jakarta.persistence.*;import lombok.AllArgsConstructor;import lombok.Data;import lombok.NoArgsConstructor;@Data@AllArgsConstructor@NoArgsConstructor@Entity@Table(name = "pet")public class Pet {    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)    @Column(name = "id")    private Long id;    private String name;    private String typeOfAnimal;    private int age;    @ManyToOne(cascade = CascadeType.ALL)    @JoinColumn(name = "owner_id", referencedColumnName = "id")    private Owner owner;    @OneToOne(cascade = CascadeType.ALL)    @JoinColumn(name = "medical_record_id", referencedColumnName = "id")    private MedicalRecord medicalRecord;    @OneToOne(cascade = CascadeType.ALL)    @JoinColumn(name = "medical_history_id", referencedColumnName = "id")    private MedicalHistory medicalHistory;  // Relación con MedicalHistory}