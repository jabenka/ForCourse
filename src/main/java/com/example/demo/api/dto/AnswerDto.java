package com.example.demo.api.dto;

import com.example.demo.api.persistence.entity.TicketEntity;

import java.util.List;

public class AnswerDto {
    private List<TicketEntity> tickets;

    public AnswerDto(List<TicketEntity> tickets) {
        this.tickets = tickets;
    }

    public AnswerDto() {
    }

    public static AnswerDtoBuilder builder() {
        return new AnswerDtoBuilder();
    }

    public List<TicketEntity> getTickets() {
        return this.tickets;
    }

    public void setTickets(List<TicketEntity> tickets) {
        this.tickets = tickets;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof AnswerDto)) return false;
        final AnswerDto other = (AnswerDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$tickets = this.getTickets();
        final Object other$tickets = other.getTickets();
        if (this$tickets == null ? other$tickets != null : !this$tickets.equals(other$tickets)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AnswerDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $tickets = this.getTickets();
        result = result * PRIME + ($tickets == null ? 43 : $tickets.hashCode());
        return result;
    }

    public String toString() {
        return "AnswerDto(tickets=" + this.getTickets() + ")";
    }

    public static class AnswerDtoBuilder {
        private List<TicketEntity> tickets;

        AnswerDtoBuilder() {
        }

        public AnswerDtoBuilder tickets(List<TicketEntity> tickets) {
            this.tickets = tickets;
            return this;
        }

        public AnswerDto build() {
            return new AnswerDto(this.tickets);
        }

        public String toString() {
            return "AnswerDto.AnswerDtoBuilder(tickets=" + this.tickets + ")";
        }
    }
}
