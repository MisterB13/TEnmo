package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.entities.Transfer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcTransferDao implements TransferDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcTransferDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Transfer mapRowToTransfer(SqlRowSet results) {
        Transfer transfer = new Transfer();
        transfer.setId(results.getInt("transfer_id"));
        transfer.setTransferTypeId(results.getInt("transfer_type_id"));
        transfer.setTransferStatusId(results.getInt("transfer_status_id"));
        transfer.setAccountFromId(results.getInt("account_from"));
        transfer.setAccountToId(results.getInt("account_to"));
        transfer.setAmount(results.getBigDecimal("amount"));
        return transfer;
    }
    @Override
    public Transfer getTransfer(int id) {
        Transfer transfer = null;
        String sql = "SELECT transfer_id, transfer_type_id, transfer_status_id, account_from, account_to, amount FROM transfer" +
                " WHERE transfer_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        while (results.next()) {
            transfer = mapRowToTransfer(results);
        }
        return transfer;
    }

    @Override
    public List<Transfer> getAllTransfers() {
        String sql = "SELECT transfer_id, transfer_type_id, transfer_status_id, account_from, account_to, amount " +
                "FROM transfers";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        List<Transfer> transfers = new ArrayList<>();
        while(results.next()){
            transfers.add(mapRowToTransfer(results));
        }
        return transfers;
    }

    @Override
    public List<Transfer> getTransferHistory(int accountId) {
        List<Transfer> transfers = new ArrayList<>();
        String sql = "SELECT transfer_id, transfer_type_id, transfer_status_id, account_from, account_to, amount " +
                "FROM transfer WHERE account_from = ? OR account_to = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, accountId, accountId);
        while (results.next()) {
            Transfer transfer = mapRowToTransfer(results);
            transfers.add(transfer);
        }
        return transfers;
    }

    @Override
    public List<Transfer> getPendingTransfers(int userId) {
        String sql = "SELECT transfer_id, transfer_type_id, transfers.transfer_status_id, account_from, account_to, amount " +
                "FROM transfers " +
                "JOIN accounts ON accounts.account_id = transfers.account_from " +
                "JOIN transfer_statuses ON transfers.transfer_status_id = transfer_statuses.transfer_status_id " +
                "WHERE user_id = ? AND transfer_status_desc = 'Pending'";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        List<Transfer> transfers = new ArrayList<>();
        while(results.next()) {
            transfers.add(mapRowToTransfer(results));
        }
        return transfers;
    }

    @Override
    public int createTransfer(Transfer transfer) {
        String sql = "INSERT INTO transfer (transfer_type_id, transfer_status_id, account_from, account_to, amount)" +
                "VALUES (2, 2, ?, ?, ?) RETURNING transfer_id";

        Integer transferId = jdbcTemplate.queryForObject(sql, Integer.class, transfer.getAccountFromId(),
                transfer.getAccountToId(), transfer.getAmount());
        return transferId;
    }

    //possibly separate into 2 separate methods one for adding one for subtracting
    @Override
    public void updateTransfer(Transfer transfer) {
        String sql = "UPDATE transfers SET transfer_status_id = ? " +
                "WHERE transfer_id = ?";

        jdbcTemplate.update(sql, transfer.getTransferStatusId(), transfer.getId());
    }
}
