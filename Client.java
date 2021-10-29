public class Client 
{
	private String name;
	private long CNP;
	private float sold_cont_euro, sold_cont_ron;
	private String pinEuro, pinRon;
	
	public Client(String name, long CNP, float sold_cont_euro, float sold_cont_ron, String pinEuro, String pinRon)
	{
		this.name = name;
		this.CNP = CNP;
		this.sold_cont_euro = sold_cont_euro;
		this.sold_cont_ron = sold_cont_ron;
		this.pinEuro = pinEuro;
		this.pinRon = pinRon;
	}
	
	
	public String getName()
	{
		return name;
	}
	
	public long getCNP()
	{
		return CNP;
	}
	
	public String getPinEuro()
	{
		return pinEuro;
	}
	
	public String getPinRon()
	{
		return pinRon;
	}
	
	public String changePin(String pin)
	{
		pin = "****";
		return pin;
	}
	
	public float getSold_cont_euro()
	{
		return sold_cont_euro;
	}
	
	public float getSold_cont_ron()
	{
		return sold_cont_ron;
	}

	public void depositEuro(String pin, float amountEuro)
	{
		if(pinEuro.equals(pin) == true)
		{	
			sold_cont_euro += amountEuro;
			System.out.println("Your amount in euro after deposit is: " + sold_cont_euro + "\n");
		}
	}
	
	public void depositRon(String pin, float amountRon)
	{
		if(pinRon.equals(pin) == true)
		{
			sold_cont_ron += amountRon;
			System.out.println("Your amount in ron after deposit is: " + sold_cont_ron+ "\n");
		}
		
	}
	
	public void withdrawalEuro(String pin, float amountEuro)
	{
		if(pinEuro.equals(pin) == true)
		{
			if (sold_cont_euro >= amountEuro) 
			{
				sold_cont_euro -= amountEuro;
				System.out.println("Your amount in euro after withdrawal is: " + sold_cont_euro+ "\n");
			}
			else
				System.out.println("Your amount in euro is less than " + amountEuro + "\tTransaction failed!\n" ); 
		}
	}
	
	public void withdrawalRon(String pin, float amountRon)
	{
		if(pinRon.equals(pin) == true)
		{
			if (sold_cont_ron >= amountRon) 
			{
				sold_cont_ron -= amountRon;
				System.out.println("Your amount in ron after withdrawal is: " + sold_cont_ron+ "\n");
			}
			else
				System.out.println("Your amount in ron is less than " + amountRon + "\tTransaction failed!\n" ); 
		}
		
	}
	
	public void updateSoldEuro(float soldEuro, long CNP)
	{
		if(this.CNP == CNP)
		{
			if(this.sold_cont_euro != soldEuro)
			{	
				this.sold_cont_euro = soldEuro;
			}
		}
	}
	
	public void updateSoldRon(float soldRon, long CNP)
	{
		if(this.CNP == CNP)
		{	
			if(this.sold_cont_ron != soldRon)
			{	
				this.sold_cont_ron = soldRon;
			}
		}
	}
	
}