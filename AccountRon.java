import java.util.ArrayList;

public class AccountRon extends Account
{
	public AccountRon(ArrayList<Client> accounts)
	{
		super(accounts);
	}
	
	public void addAccount(Client c)
	{
		this.getAccounts().add(c);
	}
	
	public Boolean removeAccount(String  pin)
	{
		for(Client c : this.getAccounts())
		{
			if(c.getPinRon().equals(pin) == true)
			{
				if(c.getSold_cont_ron() == 0)    //doar in cazul in care sold-ul este pe 0, contul respectiv poate fi sters
				{
					System.out.println("Your account in ron was deleted!\n");
					return getAccounts().remove(c);
				}
				else
					System.out.println("Your account in ron isn't 0!\n");
			}		
		}	

		return false;
	}
	
	public void showAccountDetails(String pin)
	{
		for(Client c : this.getAccounts())
		{	
			if(c.getPinRon().equals(pin) == true)
			{
				System.out.println("Your name is: " + c.getName());
				System.out.println("Your CNP is: " + c.getCNP());
				System.out.println("Your sold in ron is: " + c.getSold_cont_ron());
				System.out.println("Your pin in ron is: " + c.getPinRon());
			}
		}
	}
	
	public Boolean pinValidation(String  pin)
	{
		for(Client c : this.getAccounts())
			if(c.getPinRon().equals(pin) == true)
				return true;
	       
	       return false;
	 }
	
	public Boolean cnpValidation(long CNP)
	{
		 for(Client c : this.getAccounts())
	       if(c.getCNP() == CNP)
	           return true;
	       
	       return false;
	}
	
	public Boolean changedSold(float soldRon, long CNP)
	{
		for(Client c : this.getAccounts())
			if(c.getCNP() == CNP)
				if(c.getSold_cont_ron() != soldRon)   //daca sold-ul curent al clientului nu este egal cu cel dat ca parametru, atunci cel curent i-a valoarea celui dat ca parametru
					return true;
				
		return false;
	}
	
}
