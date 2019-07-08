package com.thoughtmechanix.spmiaauthenticationserver.security;

public class JwtConfig {

	public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";
	public static final String RSA_PRIVATE = "-----BEGIN RSA PRIVATE KEY-----\r\n" + 
			"MIIEpAIBAAKCAQEAySVVwxXrUNWNzKXU2WP5sss9quM39Q5GHEcIvw1JZTS+cINr\r\n" + 
			"8ciXfY6B7NYKjmgPK+tb2kF/lKhLQikMXD03fNRiUOyI5CBN3lOnDjGH1sf2fnEh\r\n" + 
			"7hbXqrkTfxDUCG28Rjr+1SuAJpShIL3Hi5hSyJKxTflbMI/z5K9zXt8811bAwbA8\r\n" + 
			"0m20RDQkYAj70GJbMMkm9S56sCBq3L/B9YlcV2kd5dETKQQzd0/FyZ2A5yczXHVY\r\n" + 
			"oTs119TPBtcotmkOByaURrG4c8ODW7wAzUTmh9Jo6THl/7fJvTuYxbkNXGwex0vx\r\n" + 
			"5O7ShKyrXntSYkdk2UfET1ztRzEj34zrI7nE6wIDAQABAoIBAQCOBVdtfA9/LpmF\r\n" + 
			"Ml179LP8QrZS70W2OBLWqm0JgFcfJ0ODa7eOqsQTucgQsfwYGm8D4pUjIHX1P3KL\r\n" + 
			"zzHT+sEv2UFlw+zPreNtJAFi6yPvSZbIJhb/5Y73EuAqKnabUOfLaqI9Xw6Hrw+p\r\n" + 
			"b3XyIWXqCnE4DeUN/8YD5MF/7f0mSO7zKHnPFS3R06UftEonpPGUpPDQ5122Li0e\r\n" + 
			"deR86cyD6TI3feiWA/MFDeDq8MW4nyihauhyFWwKHqEvsff5vAn6XM3Z0jA/8XSp\r\n" + 
			"2Oo1cjTrWxCNPbz1CegFLIXpHzDLb16FnrtSMy7LeTVUtTLf0bZwT8GjkYMxa4dJ\r\n" + 
			"K1PA5Z1xAoGBAP9+TFk4TC/yMJIOmc80Aryk/9X/aFIL/0PGZ8NHpa8eQq5bot0Z\r\n" + 
			"i7EqvocIsFNev7dsesQXtoPoTdOuWh9IRI1yrrnjA8jOOo/J2JTwdYa3bLqJzL0f\r\n" + 
			"GgayXdHlSLHQ5Vk474MRVnZWZdPPfF4y0VNFToFDTNYB78Nvn60xYFu5AoGBAMmL\r\n" + 
			"cneS2xy/orSPxsOEne3noz7Qj+61YU33IUTPD1jPzdhNfr7jRQIAynYRQLw+eFnZ\r\n" + 
			"Ze/X/CCiuoI9byhsnwB8h9+p71nDNll/MPUXYQ0NUHnc83T/q5evSSeI8v/xH0tS\r\n" + 
			"298oDLvaq9vhPMZnoj+0972jLdhq4IuGbG0nPJ/DAoGAXz5G2e+5vxnq71fQEMUT\r\n" + 
			"zB06Xh0zV3qvcyWQYuTfp/OA6hyxDvlJ8Qa9NfuQN9QXZhpjfZxVZsD/2kyhvg2j\r\n" + 
			"uJMq/ZLaQ05V2GpnecZWGZ1hQ/zAvTPN8PcnMGrn+ZmlFei6qMKa18yHczli5H7P\r\n" + 
			"N9qbVGaxSwo3xkRjYx4IDMkCgYAqOT638lpZQYSy01RO7d+wUdEPfd5JolJKZTXh\r\n" + 
			"FogekRqM8F9XWoHAk63W4nJvfZ71I+iJQPSfWbg9ROWe0HLXRT+qCg4M/irKwSze\r\n" + 
			"jBFXDK0JetK+djnaw2xODhDqsfdebnOF4vwX9w3+OMfkwR1qv10Pq7oVFv8H/BeH\r\n" + 
			"HqtCxQKBgQDxgOZ9BPJN3pSt/mlWIaNYJEDWNG8SRshtzfwpsYUuJZnug4bgwYJs\r\n" + 
			"p48wkvYx0fkpFxxr9yOlXtWKbfttyuazNsddc1bZKnFIMnQNn8OrzgUI0z6piwYM\r\n" + 
			"cM9dm6057h90LF1itwIqjDDgAMmqQ21mWPC5Qx/9/0FIwxsEn8VJ/g==\r\n" + 
			"-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUBLIC = "-----BEGIN PUBLIC KEY-----\r\n" + 
			"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAySVVwxXrUNWNzKXU2WP5\r\n" + 
			"sss9quM39Q5GHEcIvw1JZTS+cINr8ciXfY6B7NYKjmgPK+tb2kF/lKhLQikMXD03\r\n" + 
			"fNRiUOyI5CBN3lOnDjGH1sf2fnEh7hbXqrkTfxDUCG28Rjr+1SuAJpShIL3Hi5hS\r\n" + 
			"yJKxTflbMI/z5K9zXt8811bAwbA80m20RDQkYAj70GJbMMkm9S56sCBq3L/B9Ylc\r\n" + 
			"V2kd5dETKQQzd0/FyZ2A5yczXHVYoTs119TPBtcotmkOByaURrG4c8ODW7wAzUTm\r\n" + 
			"h9Jo6THl/7fJvTuYxbkNXGwex0vx5O7ShKyrXntSYkdk2UfET1ztRzEj34zrI7nE\r\n" + 
			"6wIDAQAB\r\n" + 
			"-----END PUBLIC KEY-----";
}
