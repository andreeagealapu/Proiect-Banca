import java.util.ArrayList;

public class AccountEuro extends Account
{	
	public AccountEuro(ArrayList<Client> accounts)
	{
		super(accounts);
	}
	
	public void addAccount(Client c)
	{
		this.getAccounts().add(c);
	}
	
	public Boolean removeAccount(String pin)
	{
		for(Client c : this.getAccounts())
		{
			if(c.getPinEuro().equals(pin) == true)
			{
				if(c.getSold_cont_euro() == 0)  //doar in cazul in care sold-ul este pe 0, contul respectiv poate fi sters
				{
					System.out.println("Your account in euro was deleted!\n");
					return getAccounts().remove(c);
				}
				else
					System.out.println("Your account in euro isn't 0!\n");
			}
		}	
		
	
		return false;
	}
	
	public void showAccountDetails(String pin)
	{
		for(Client c : this.getAccounts())
		{
			if(c.getPinEuro().equals(pin) == true)
			{
				System.out.println("Your name is: " + c.getName());
				System.out.println("Your CNP is: " + c.getCNP());
				System.out.println("Your sold in euro is: " + c.getSold_cont_euro());
				System.out.println("Your pin in euro is: " + c.getPinEuro());
			}
		}	
	}
	
	 public Boolean pinValidation(String pin)  
	 {
		 for(Client c : this.getAccounts())
		       if(c.getPinEuro().equals(pin) == true)
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
	 
	public Boolean changedSold(float soldEuro, long CNP)
	{
		 for(Client c : this.getAccounts())
			if(c.getCNP() == CNP)
				if(c.getSold_cont_euro() != soldEuro)    //daca sold-ul curent al clientului nu este egal cu cel dat ca parametru, atunci cel curent i-a valoarea celui dat ca parametru
					return true;
			
		 return false;
	}
		
}
