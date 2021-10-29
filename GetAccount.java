import java.util.ArrayList;

public class GetAccount 
{
	private ArrayList<Client> accountEuro = new ArrayList<>();
	private ArrayList<Client> accountRon = new ArrayList<>();

	public GetAccount(ArrayList<Client> accountEuro, ArrayList<Client> accountRon) 
	{
		this.accountEuro = accountEuro;
		this.accountRon = accountRon;
	}
	
	public Account getAccount(ArrayList<Client> accountType)
	{
		
		if(accountType == null)  
        {
			return null;  
        }
           
		if(accountType == accountEuro)  
                return new AccountEuro(accountEuro);  
                 
         else if(accountType == accountRon)  
               return new AccountRon(accountRon);  
         
     return null;  
	}
}
