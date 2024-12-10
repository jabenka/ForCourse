package com.example.demo.api.persistence.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String status;

    @OneToMany
    private
    List<TicketEntity> tickets;

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getStatus() {
        return this.status;
    }

    public List<TicketEntity> getTickets() {
        return this.tickets;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTickets(List<TicketEntity> tickets) {
        this.tickets = tickets;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UserEntity)) return false;
        final UserEntity other = (UserEntity) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        final Object this$tickets = this.getTickets();
        final Object other$tickets = other.getTickets();
        if (this$tickets == null ? other$tickets != null : !this$tickets.equals(other$tickets)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UserEntity;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        final Object $tickets = this.getTickets();
        result = result * PRIME + ($tickets == null ? 43 : $tickets.hashCode());
        return result;
    }

    public String toString() {
        return "UserEntity(id=" + this.getId() + ", name=" + this.getName() + ", status=" + this.getStatus() + ", tickets=" + this.getTickets() + ")";
    }
}
