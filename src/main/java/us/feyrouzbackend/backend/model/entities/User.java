package us.feyrouzbackend.backend.model.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.sql.Timestamp;
import java.util.UUID;

@Entity(name = "User")
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(generator = "UUID")
  @UuidGenerator
  private UUID id;

  @Column(name = "keycloak_id", nullable = false)
  private UUID keycloakId;

  @Column(name = "first_name", nullable = false)
  private String firstName;

  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(name = "email")
  private String email;

  @Column(name = "phone")
  private String phone;

  @Column(name = "created_at", nullable = false)
  private Timestamp createdAt;

  @Column(name = "updated_at", nullable = false)
  private Timestamp updatedAt;

  public UUID getId() {
    return id;
  }

  public User setId(UUID id) {
    this.id = id;
    return this;
  }

  public UUID getKeycloakId() {
    return keycloakId;
  }

  public User setKeycloakId(UUID keycloakId) {
    this.keycloakId = keycloakId;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }

  public User setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public User setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public User setEmail(String email) {
    this.email = email;
    return this;
  }

  public String getPhone() {
    return phone;
  }

  public User setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public Timestamp getCreatedAt() {
    return createdAt;
  }

  public User setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public Timestamp getUpdatedAt() {
    return updatedAt;
  }

  public User setUpdatedAt(Timestamp updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }
}

