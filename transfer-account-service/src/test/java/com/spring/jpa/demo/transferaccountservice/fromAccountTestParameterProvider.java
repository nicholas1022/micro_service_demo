package com.spring.jpa.demo.transferaccountservice;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class fromAccountTestParameterProvider implements ArgumentsProvider {

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
		
		return Stream.of(new BigInteger("1"), new BigInteger("2"), new BigDecimal("10"), new BigDecimal("9990")).map(Arguments::of);
	}

}
