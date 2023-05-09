# ATM Part One:
Simulate an ATM (automatic teller machine) that handles checking
and savings accounts.

The ATM is used by the customers of a bank. 
1) Each customer has two accounts: a checking account and a savings account. 
2) Each customer also has a customer number and a personal identification number (PIN);
both are required to gain access to the accounts. With the ATM, customers can
select an account (checking or savings). The balance of the selected account is displayed. Then
the customer can deposit and withdraw money. This process is repeated until the customer
chooses to exit.


# Here is a typical dialog:

Enter customer number: 1
Enter PIN: 1234
A=Checking, B=Savings, C=Quit: a
Balance=0.0
A=Deposit, B=Withdrawal, C=Cancel: a
Amount: 1000
A=Checking, B=Savings, C=Quit: a
Balance=1000.0
A=Deposit, B=Withdrawal, C=Cancel: c
A=Checking, B=Savings, C=Quit: b
Balance=0.0
A=Deposit, B=Withdrawal, C=Cancel: a
Amount: 5000
A=Checking, B=Savings, C=Quit: b
Balance=5000.0
A=Deposit, B=Withdrawal, C=Cancel: b
Amount: 1500
A=Checking, B=Savings, C=Quit: b
Balance=3500.0
A=Deposit, B=Withdrawal, C=Cancel: c
A=Checking, B=Savings, C=Quit: c
Enter customer number: 2
Enter PIN: 2345
A=Checking, B=Savings, C=Quit: a
Balance=0.0
A=Deposit, B=Withdrawal, C=Cancel: c

Because this is a simulation, the ATM does not actually communicate with a bank. It simply loads
a set of customer numbers and PINs from a file. All accounts are initialized with a zero balance.
# The project must have at least the following classes:
1- BankAccount
A bank account has a balance that can be changed by deposits and withdrawals.
2- Customer
A bank customer with a checking and a savings account.
3- Bank
A bank contains a collection of customers. When a user walks up to the ATM and enters
a customer number and PIN, it is the job of the bank to find the matching customer.
4- ATM
The ATM has a state. The current machine state determines the text of the prompts and
the function to be done. For example, when you first log in, you select an account. Next,
you use choose between deposit and withdrawal. The ATM must remember the current
state so that it can correctly interpret the action to be done. There are four states:
1. START: Enter customer ID
2. PIN: Enter PIN
3. ACCOUNT: Select account
4. TRANSACT: Select transaction
