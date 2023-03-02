package com.telusko.block.tokens;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Working with Token
 */
@Repository
public interface TokenRepository extends CassandraRepository<Token, String> {

    /**
     * Address is the PK of the table
     * @param address
     *      address
     * @return
     *      token is exists
     */
    Optional<Token> findByAddress(String address);

}