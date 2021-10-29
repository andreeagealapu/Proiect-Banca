import java.util.ArrayList;

public abstract class Account 
{
	private ArrayList<Client> accounts = new ArrayList<>();
	
	public Account(ArrayList<Client> accounts)
	{
		this.accounts = accounts;
	}
	
	public ArrayList<Client> getAccounts()
	{
		return accounts;
	}
	
	abstract public void addAccount(Client c);
	abstract public Boolean removeAccount(String pin);
	abstract public void showAccountDetails(String pin);
	abstract public Boolean pinValidation(String  pin);
	abstract public Boolean cnpValidation(long CNP);
	abstract public Boolean changedSold(float sold, long CNP);

}
