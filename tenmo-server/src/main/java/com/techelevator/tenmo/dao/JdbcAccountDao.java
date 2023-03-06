package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.entities.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcAccountDao implements AccountDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Account mapResultsToAccount(SqlRowSet results) {
        Account account = new Account();
        account.setId(results.getInt("account_id"));
        account.setUserId(results.getInt("user_id"));
        account.setBalance(results.getBigDecimal("balance"));
        return account;
    }

    @Override
    public Account getUserAccount(int userId) {
        String sql = "SELECT account_id, user_id, balance FROM accounts WHERE user_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, userId);
        Account account = null;
        if(result.next()) {
            account = mapResultsToAccount(result);
        }
        return account;
    }

    @Override
    public Account getAccountByAccountID(int accountId) {
        String sql = "SELECT account_id, user_id, balance FROM accounts WHERE account_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, accountId);
        Account account = null;
        if(result.next()) {
            account = mapResultsToAccount(result);
        }
        return account;
    }

    @Override
    public void updateAccount(Account accountToUpdate) {
        String sql = "UPDATE accounts SET balance = ? " +
                "WHERE account_id = ?";

        jdbcTemplate.update(sql, accountToUpdate.getBalance(), accountToUpdate.getId());
    }
}
