package com.telusko.block.tokens;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.math.BigInteger;
import java.time.Instant;

@Table(value = "tokens")
public class Token {

    @PrimaryKeyColumn(name = "address", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    @CassandraType(type = CassandraType.Name.TEXT)
    private String address;

    @PrimaryKeyColumn(name = "block_number", ordinal = 0, type = PrimaryKeyType.CLUSTERED)
    @CassandraType(type = CassandraType.Name.BIGINT)
    private BigInteger block_number;

    @Column("block_hash")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String block_hash;

    @Column("block_timestamp")
    @CassandraType(type = CassandraType.Name.TIMESTAMP)
    private Instant block_timestamp;

    @Column("decimals")
    @CassandraType(type = CassandraType.Name.INT)
    private int decimals;

    @Column("name")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String name;

    @Column("symbol")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String symbol;

    @Column("total_supply")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String total_supply;

    public Token() {
    }

    /**
     * Gets block_number
     *
     * @return value of block_number
     */
    public BigInteger getBlock_number() {
        return block_number;
    }

    /**
     * Set value for block_number
     *
     * @param block_number
     *         new value for block_number
     */
    public void setBlock_number(BigInteger block_number) {
        this.block_number = block_number;
    }

    /**
     * Gets block_hash
     *
     * @return value of block_hash
     */
    public String getBlock_hash() {
        return block_hash;
    }

    /**
     * Set value for block_hash
     *
     * @param block_hash
     *         new value for block_hash
     */
    public void setBlock_hash(String block_hash) {
        this.block_hash = block_hash;
    }

    /**
     * Gets block_timestamp
     *
     * @return value of block_timestamp
     */
    public Instant getBlock_timestamp() {
        return block_timestamp;
    }

    /**
     * Set value for block_timestamp
     *
     * @param block_timestamp
     *         new value for block_timestamp
     */
    public void setBlock_timestamp(Instant block_timestamp) {
        this.block_timestamp = block_timestamp;
    }

    /**
     * Gets decimals
     *
     * @return value of decimals
     */
    public int getDecimals() {
        return decimals;
    }

    /**
     * Set value for decimals
     *
     * @param decimals
     *         new value for decimals
     */
    public void setDecimals(int decimals) {
        this.decimals = decimals;
    }

    /**
     * Gets name
     *
     * @return value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set value for name
     *
     * @param name
     *         new value for name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets symbol
     *
     * @return value of symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Set value for symbol
     *
     * @param symbol
     *         new value for symbol
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Gets total_supply
     *
     * @return value of total_supply
     */
    public String getTotal_supply() {
        return total_supply;
    }

    /**
     * Set value for total_supply
     *
     * @param total_supply
     *         new value for total_supply
     */
    public void setTotal_supply(String total_supply) {
        this.total_supply = total_supply;
    }
}
