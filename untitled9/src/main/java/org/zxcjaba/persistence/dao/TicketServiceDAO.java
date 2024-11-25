package org.zxcjaba.persistence.dao;

import org.zxcjaba.persistence.entity.TicketType;
import org.zxcjaba.persistence.entity.User;

import java.sql.*;
import org.zxcjaba.persistence.entity.Ticket;

public class TicketServiceDAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/gambling";
    private static final String USER = "postgres";
    private static final String PASSWORD = "19031988";
    static TicketServiceDAO ticketServiceDAO;

    private TicketServiceDAO(){

    }

    public static TicketServiceDAO getTicketServiceDAO() {
        if (ticketServiceDAO == null) {
            ticketServiceDAO = new TicketServiceDAO();
        }
        return ticketServiceDAO;
    }

    public void saveUser(User user) throws SQLException {
        String sql = "INSERT INTO ticket.User (name) VALUES (?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, user.getName());
            pstmt.executeUpdate();
            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    user.setId(rs.getInt(1));
                }
            }
        }
    }

    public User getUserById(int id) throws SQLException {
        String sql = "SELECT * FROM ticket.User WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new User(rs.getInt("id"), rs.getString("name"));
                }
            }
        }
        return null;
    }

    public void saveTicket(Ticket ticket) throws SQLException {
        String sql = "INSERT INTO ticket.Ticket (user_id, ticket_type) VALUES (?, ?::Ticket_type)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, ticket.getUserId());
            pstmt.setString(2, String.valueOf(ticket.getTicketType()));
            pstmt.executeUpdate();
            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    ticket.setId(rs.getInt(1));
                }
            }
        }
    }

    public Ticket getTicketById(int id) throws SQLException {
        String sql = "SELECT * FROM ticket.Ticket WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Ticket(rs.getInt("id"), rs.getInt("user_id"),
                            TicketType.valueOf(rs.getString("ticket_type")), rs.getTimestamp("created_date"));
                }
            }
        }
        return null;
    }

    public void updateTicketType(int ticketId, String newType) throws SQLException {
        String sql = "UPDATE public.Ticket SET ticket_type = ?::Ticket_type WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newType);
            pstmt.setInt(2, ticketId);
            pstmt.executeUpdate();
        }
    }

    public void deleteUserById(int userId) throws SQLException {
        String deleteTicketsSql = "DELETE FROM ticket.Ticket WHERE user_id = ?";
        String deleteUserSql = "DELETE FROM ticket.User WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            conn.setAutoCommit(false);
            Savepoint savepoint = conn.setSavepoint();

            try (PreparedStatement deleteTicketsStmt = conn.prepareStatement(deleteTicketsSql);
                 PreparedStatement deleteUserStmt = conn.prepareStatement(deleteUserSql)) {

                deleteTicketsStmt.setInt(1, userId);
                deleteTicketsStmt.executeUpdate();

                deleteUserStmt.setInt(1, userId);
                deleteUserStmt.executeUpdate();

                conn.commit();
            } catch (SQLException e) {
                conn.rollback(savepoint);
                throw e;
            } finally {
                conn.setAutoCommit(true);
            }
        }
    }
}
