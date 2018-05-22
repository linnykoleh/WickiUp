package com.linnyk.jpa.safari.util;

import java.math.BigDecimal;
import java.util.Date;

import com.linnyk.jpa.safari.entities.User;
import com.linnyk.jpa.safari.entities.Account;
import com.linnyk.jpa.safari.entities.association.Credential;
import com.linnyk.jpa.safari.entities.association.Transaction;
import com.linnyk.jpa.safari.entities.compound.Currency;
import com.linnyk.jpa.safari.entities.embedded.Bank;
import com.linnyk.jpa.safari.entities.inheritance.Bond;
import com.linnyk.jpa.safari.entities.inheritance.Stock;
import com.linnyk.jpa.safari.entities.join_table.Budget;

public class EntitiesUtil {

	public static User getUser(String fn, String ln) {
		final User user = new User();
		user.setBirthDate(new Date());
		user.setCreatedDate(new Date());
		user.setCreatedBy("Oleh ANNOTATION 1");
		user.setEmailAddress("Oleh@Linnyk.com");
		user.setFirstName(fn);
		user.setLastName(ln);
		user.setLastUpdatedDate(new Date());
		user.setLastUpdatedBy("Oleh");
		return user;
	}

	public static Transaction getTransaction(String title, String transactionType) {
		final Transaction transaction = new Transaction();
		transaction.setTitle(title);
		transaction.setTransactionType(transactionType);
		transaction.setAmount(BigDecimal.TEN);
		transaction.setInitialBalance(BigDecimal.TEN);
		transaction.setCreatedBy("Oleh");
		transaction.setCreatedDate(new Date());
		transaction.setLastUpdatedBy("Oleh");
		transaction.setLastUpdatedDate(new Date());
		transaction.setClosingBalance(BigDecimal.ONE);
		return transaction;
	}

	public static Account getAccount(String name) {
		final Account account = new Account();
		account.setName(name);
		account.setInitialBalance(BigDecimal.TEN);
		account.setCurrentBalance(BigDecimal.ONE);
		account.setOpenDate(new Date());
		account.setCloseDate(new Date());
		account.setCreatedBy("Oleh");
		account.setCreatedDate(new Date());
		account.setLastUpdatedBy("Oleh");
		account.setLastUpdatedDate(new Date());
		return account;
	}

	public static Budget getBudget() {
		final Budget budget = new Budget();
		budget.setGoalAmount(BigDecimal.TEN);
		budget.setName("Emergency Fund");
		budget.setPeriod("Yearly");
		return budget;
	}

	public static Credential getCredential(String password, String username) {
		final Credential credential = new Credential();
		credential.setPassword(password);
		credential.setUsername(username);
		return credential;
	}

	public static Bank getBank(String name) {
		final Bank bank = new Bank();
		bank.setName(name);
		bank.setAddressLine1("33 Wall Street");
		bank.setAddressLine2("Suite 2");
		bank.setCity("New York");
		bank.setState("NY");
		bank.setZipCode("27914");
		bank.setCreatedBy("Kevin Bowersox");
		bank.setCreatedDate(new Date());
		bank.setLastUpdatedBy("Kevin Bowersox");
		bank.setLastUpdatedDate(new Date());
		bank.setInternational(false);
		return bank;
	}

	public static Currency getCurrency(String name) {
		final Currency currency = new Currency();
		currency.setCountryName("United States");
		currency.setName(name);
		currency.setSymbol("$");
		return currency;
	}

	public static Stock getStock(String name) {
		final Stock stock = new Stock();
		stock.setName(name);
		stock.setQuantity(BigDecimal.TEN);
		stock.setSharePrice(BigDecimal.ONE);
		stock.setIssuer("Issuer");
		stock.setPurchaseDate(new Date());
		return stock;
	}

	public static Bond getBond(String name) {
		final Bond bond = new Bond();
		bond.setName(name);
		bond.setInterestRate(BigDecimal.TEN);
		bond.setMaturityDate(new Date());
		bond.setValue(BigDecimal.ONE);
		bond.setIssuer("Issuer");
		bond.setPurchaseDate(new Date());
		return bond;
	}
}
