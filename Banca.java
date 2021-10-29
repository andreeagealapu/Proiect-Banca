import java.util.ArrayList;
import java.util.Scanner;

public class Banca 
{
	private static Scanner sc;

	public static void main(String[] args) 
	{
		sc = new Scanner(System.in); 
		ArrayList<Client> accountsEuro = new ArrayList<>();
		ArrayList<Client> accountsRon = new ArrayList<>();
		GetAccount acc = new GetAccount(accountsEuro, accountsRon);
		ArrayList<Client> fisc = new ArrayList<>();
		Fisc f = new Fisc(fisc);
		boolean ok=true;

		System.out.println("Main Menu:\n" +
				"1. Client Menu\n" +
				"2. Fisc Menu\n" +
				"3. Exit\n");

		while(ok == true)
		{
			int ch;
			boolean ok1=true, ok3=true;

			System.out.println("\nEnter your choice: "); 
			ch = sc.nextInt();
			
			if(ch == 1)
			{
				System.out.println("Client Menu:\r\n" +
						"1. Create an account\r\n" +
						"2. Remove an account\r\n" +
						"3. Deposit or Withdrawal an account\r\n" +
						"4. Show account details\r\n" +
						"5. Exit\n");

				while(ok1==true)
				{
					int ch1;
					String name;
					long CNP;
					float sold_cont_euro, sold_cont_ron;
					String pinEuro = null, pinRon;
					
					System.out.println("\nEnter your choice: "); 
					ch1 = sc.nextInt(); 

					switch(ch1) 
					{
					case 1: 
						System.out.println("Please enter your name: ");
						name=sc.next();
						
						System.out.println("Please enter your CNP: ");
						CNP=sc.nextLong();
						
						int length = (int) (Math.log10(CNP) + 1);
						
						//pentru a se inregistra CNp-ul clientului, acesta trebuie sa aiba lungimea egala cu 13
						while(length != 13)                        
						{
							System.out.println("Your CNP must have 13 digits. Please try again: ");
							CNP=sc.nextLong();
							length = (int) (Math.log10(CNP) + 1);						
						}
						
						if(length == 13)
							System.out.println("Your CNP had been registered. Thank you! ");
						
						System.out.println("Please enter your amount in euro: ");
						sold_cont_euro=sc.nextFloat();
						
						//pentru ca clientul sa creeze contul trebuie sa aiba un sold de minim 1000 de euro/ron
						while(sold_cont_euro < 1000)
						{
							System.out.println("You can't create an account with less than 1000 euro! Please try again: ");
							sold_cont_euro=sc.nextFloat();
						}
						if (sold_cont_euro >= 1000)
							System.out.println("Your account in euro was created. Thank you! ");

						System.out.println("Please enter your pin for euro account: ");
						pinEuro=sc.next();
						
						//pentru ca clientul sa isi creeze contul trebuie sa introduca un pin care nu a mai fost folosit si care are lungimea egala cu 4
						while(acc.getAccount(accountsRon).pinValidation(pinEuro) == true || acc.getAccount(accountsEuro).pinValidation(pinEuro) == true)
						{
							System.out.println("You can't use this pin. Please try again: ");
							pinEuro=sc.next();
						}
						
						int length1 = pinEuro.length();
						
						while(length1 != 4)
						{
							System.out.println("Your pin must have 4 digits. Please try again: ");
							pinEuro=sc.next();
							length1 = pinEuro.length();						
						}
						
						if(acc.getAccount(accountsRon).pinValidation(pinEuro) == false && acc.getAccount(accountsEuro).pinValidation(pinEuro) == false && length1 == 4)
							System.out.println("Your pin for your account in euro has been set. Thank you! ");

						System.out.println("Please enter your amount in ron: ");
						sold_cont_ron=sc.nextFloat();  		
						
						while(sold_cont_ron < 1000)
						{
							System.out.println("You can create an account with less than 1000 ron! Please try again: ");
							sold_cont_ron=sc.nextFloat(); 
						}
						if(sold_cont_ron >= 1000)
							System.out.println("Your account in ron was created. Thank you! ");

						System.out.println("Please enter your pin for ron account: ");
						pinRon=sc.next();
					
						while(acc.getAccount(accountsRon).pinValidation(pinRon) == true || acc.getAccount(accountsEuro).pinValidation(pinRon) == true || pinRon.equals(pinEuro) == true)
						{
							System.out.println("You can't use this pin. Please try again: ");
							pinRon=sc.next();
						}
						
						int length2 = pinRon.length();
						
						while(length2 != 4)
						{
							System.out.println("Your pin must have 4 digits. Please try again: ");
							pinRon=sc.next();
							length2 = pinEuro.length();						
						}
						
						if(acc.getAccount(accountsRon).pinValidation(pinRon) == false && acc.getAccount(accountsEuro).pinValidation(pinRon) == false &&  pinRon.equals(pinEuro) == false && length2 == 4)
							System.out.println("Your pin for your account in ron has been set. Thank you! ");
						
						Client c = new Client(name, CNP, sold_cont_euro, sold_cont_ron, pinEuro, pinRon);
						acc.getAccount(accountsEuro).addAccount(c);        //adaug cleintul in lista pentru conturile in eruo
						acc.getAccount(accountsRon).addAccount(c);		   //adaug cleintul in lista pentru conturile in eruo

						break;

					case 2:
						System.out.println("Please enter your account pin: ");
						String pin = sc.next();
						
						//verific daca pin-ul introdus se afla printele cele ale clientilor si in functie de acesta sterg fie contul de euro, fie cel de ron, caruia ii corespunde acel pin
						if(acc.getAccount(accountsEuro).pinValidation(pin)==true)
							acc.getAccount(accountsEuro).removeAccount(pin);
						else if(acc.getAccount(accountsRon).pinValidation(pin)==true)
							acc.getAccount(accountsRon).removeAccount(pin);
						else
							System.out.println("The pin isn't correct or doesn't exist!\n");

						break;

					case 3:
						boolean ok2=true;

						System.out.println("Deposit or Withdrawal Menu:\r\n" +
								"1. Deposit in account\r\n" +
								"2. Withdrawal from account\r\n" +
								"3. Exit\n");

						while(ok2==true)
						{
							int ch2;
							float amount;

							System.out.println("\nEnter your choice: "); 
							ch2 = sc.nextInt(); 
							switch(ch2) 
							{
							case 1:
								System.out.println("Please enter your account pin: ");
								pin = sc.next();

								
								//verific daca pin-ul introdus se afla printele cele ale clientilor si in functie de acesta aduna suma de euro/ron introdusa de client
								if(acc.getAccount(accountsEuro).pinValidation(pin)==true)
								{
									System.out.println("Please enter your amount in euro that you want to deposit: ");
									amount = sc.nextFloat();

									for(Client client : acc.getAccount(accountsEuro).getAccounts())
										client.depositEuro(pin, amount);
								}
								else if(acc.getAccount(accountsRon).pinValidation(pin)==true)
								{
									System.out.println("Please enter your amount in ron that you want to deposit: ");
									amount = sc.nextFloat();

									for(Client client : acc.getAccount(accountsRon).getAccounts())
										client.depositRon(pin, amount);
								}
								else
									System.out.println("The pin isn't correct or doesn't exist!\n");

								break;

							case 2:
								System.out.println("Please enter your account pin: ");
								pin = sc.next();
								
								//verific daca pin-ul introdus se afla printele cele ale clientilor si in functie de acesta scade suma de euro/ron introdusa de client
								if(acc.getAccount(accountsEuro).pinValidation(pin)==true)
								{
									System.out.println("Please enter your amount in euro that you want to withdrawal: ");
									amount= sc.nextFloat();

									for(Client client : acc.getAccount(accountsEuro).getAccounts())
										client.withdrawalEuro(pin, amount);
								}
								else if(acc.getAccount(accountsRon).pinValidation(pin)==true)
								{
									System.out.println("Please enter your amount in ron that you want to withdrawal: ");
									amount= sc.nextFloat();

									for(Client client : acc.getAccount(accountsRon).getAccounts())
										client.withdrawalRon(pin, amount);
								}
								else
									System.out.println("The pin isn't correct or doesn't exist!\n");

								break;

							case 3:
								ok2=false;
								System.out.println("Check your account after deposit or withdrawal.\n");
								
								break;

							default:
								if(ch2<1 || ch2>3)
									System.out.println("Wrong choice! Please enter a value from 1 to 3.\n");

								break;
							}
						}

					case 4:
						System.out.println("Please enter your account pin: ");
						pin = sc.next();
						
						//verific daca pin-ul introdus se afla printele cele ale clientilor si in functie de acesta afisez toate detaliile pentru contul respectiv
						if(acc.getAccount(accountsEuro).pinValidation(pin)==true)
								acc.getAccount(accountsEuro).showAccountDetails(pin);
						else if(acc.getAccount(accountsRon).pinValidation(pin)==true)
								acc.getAccount(accountsRon).showAccountDetails(pin);
						else
							System.out.println("The pin isn't correct or doesn't exist!\n");

						break;

					case 5:
						ok1=false;
						System.out.println("Exit.\n");
						System.out.println("Main Menu:\n" +
								"1. Client Menu\n" +
								"2. Fisc Menu\n" +
								"3. Exit\n");
						break;

					default:
						if(ch1<1 || ch1>5)
							System.out.println("Wrong choice! Please enter a value from 1 to 5.\n");

						break;

					}
				}
			}

			else if(ch == 2)
			{
				System.out.println("Fisc Menu:\r\n" +
						"1. Start the monitoring procedure of a client.\r\n" +
						"2. End the monitoring procedure of a client.\r\n" +
						"3. Notify when any account of a monitored client has changed.\r\n" +
						"4. Exit\n");

				while(ok3==true)
				{
					int ch3;
					long clientCNP;

					System.out.println("\nEnter your choice: "); 
					ch3 = sc.nextInt(); 

					switch(ch3) 
					{
					case 1:
						System.out.println("Please enter the client CNP that you want to monitorize: ");
						clientCNP = sc.nextLong();
						 
						//verific dacalista pentru fisc este goala sau daca CNP-ul introdus nu se afla in lista
						if(fisc.isEmpty() == true|| f.cnpValidation(clientCNP) == false)
						{	
							//apoi verific daca CNP-ul introsu se afla in lista pentru conturile in euro, respectiv in lista pentru conturile in ron, iar daca se regaseste in una dintre ele sau in ambele, atunci adaug clientul in lista pentru fisc
							if(acc.getAccount(accountsEuro).cnpValidation(clientCNP) == true && acc.getAccount(accountsRon).cnpValidation(clientCNP) == false)
							{
								for(Client client: accountsEuro)
									f.addClient(client, clientCNP);
								System.out.println("You started monitorizing client: " + clientCNP);
							}
							else if(acc.getAccount(accountsEuro).cnpValidation(clientCNP) == false && acc.getAccount(accountsRon).cnpValidation(clientCNP) == true)
							{
								for(Client client: accountsRon)
									f.addClient(client, clientCNP);
								System.out.println("You started monitorizing client: " + clientCNP);
							}		
							else if(acc.getAccount(accountsEuro).cnpValidation(clientCNP) == true && acc.getAccount(accountsRon).cnpValidation(clientCNP) == true)
							{
								for(Client client: accountsEuro)
									f.addClient(client, clientCNP);
								System.out.println("You started monitorizing client: " + clientCNP);
							}
							else if(acc.getAccount(accountsEuro).cnpValidation(clientCNP) == false && acc.getAccount(accountsRon).cnpValidation(clientCNP) == false)
								System.out.println("This CNP isn't correct or doesn't exist!\n");
						
						}
						//in caz contrar, daca CNP_ul se gaseste deja in lista dpentru fisc, atunci se va primi un mesaj
						else if(f.cnpValidation(clientCNP) == true )
						{
							System.out.println("This CNP is already monitorized!\n");
						}
						

						break;

					case 2:
						System.out.println("Please enter the client CNP that you don't want to monitorize: ");
						clientCNP = sc.nextLong();
						
						//verific daca CNP-ul introdus se afla in lista pentru fisc, iar daca da il sterg din lista
						if(f.cnpValidation(clientCNP) == true )
						{
							f.removeClient(clientCNP);
							System.out.println("You stoped monitorizing client: " + clientCNP);
						}
						else 
							System.out.println("This CNP isn't correct or doesn't exist!\n");

						break;

					case 3:
						//pentru cloentii monitorizati de catre fisc, adica cei adaugati in lista fisc, verific daca sold-ul in euro sau in ron mai este acelasi cu cel din lista pentru conturile in euro, respectiv cu lista pentru conturile in ron
						for(Client client : fisc)
						{	
							if(acc.getAccount(accountsEuro).cnpValidation(client.getCNP()) == true)
							{
								if(acc.getAccount(accountsEuro).changedSold(client.getSold_cont_euro(), client.getCNP()) == true)
								{
									//in cazul in care sold-ul in euro s-a modificat, afisez un mesaj in acest sens impreuna cu detaliile despre acel client
									for(Client c: accountsEuro)
										if(c.getCNP() == client.getCNP())	
										{
											System.out.println("For client " + client.getCNP() + " the sold from account in euro has changed from " + client.getSold_cont_euro() + " to " + c.getSold_cont_euro());
											client.updateSoldEuro(c.getSold_cont_euro(), client.getCNP());
										}
									System.out.println("\nClient updated details: ");
									f.showClientDetails(client.getCNP());
								}
								else
									System.out.println("\nFor client " + client.getCNP() + " the sold in euro hasn't changed.\n");
							}
							else 
								System.out.println("This CNP isn't correct or doesn't exist!\n");
							if(acc.getAccount(accountsEuro).cnpValidation(client.getCNP()) == true)
							{
								if(acc.getAccount(accountsRon).changedSold(client.getSold_cont_ron(), client.getCNP()) == true)
								{
									//in cazul in care sold-ul in ron s-a modificat, afisez un mesaj in acest sens impreuna cu detaliile despre acel client
									for(Client c: accountsRon)
										if(c.getCNP() == client.getCNP())	
										{
											System.out.println("For client " + client.getCNP() + " the sold from account in ron has changed from " + client.getSold_cont_ron() + " to " + c.getSold_cont_ron());
											client.updateSoldRon(c.getSold_cont_ron(), client.getCNP());
										}
									
									System.out.println("\nClient updated details: ");
									f.showClientDetails(client.getCNP());
								}
								else
									System.out.println("\nFor client " + client.getCNP() + " the sold in ron hasn't changed.\n");
							}
							else 
								System.out.println("This CNP isn't correct or doesn't exist!\n");
						}					
						break;

					case 4:
						ok3=false;
						System.out.println("Exit.\n");
						System.out.println("Main Menu:\n" +
								"1. Client Menu\n" +
								"2. Fisc Menu\n" +
								"3. Exit\n");
						break;

					default:
						if(ch3<1 || ch3>4)
							System.out.println("Wrong choice! Please enter a value from 1 to 4.\n");

						break;
					}
				}
			}
			
			else if(ch == 3)
			{
				ok=false;
				System.out.println("Exit.\n");
				break;
			}
			
			else
				System.out.println("Wrong choice! Please enter a value from 1 to 3.\n");
			
		}

	}
}