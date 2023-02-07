using System;
using System.Collections;
using System.DirectoryServices;

namespace UserInfo.Services;

internal class LdapQuery
{
	private DirectoryEntry entry;

	private DirectorySearcher ds;

	public LdapQuery()
	{
		//IL_0018: Unknown result type (might be due to invalid IL or missing references)
		//IL_0022: Expected O, but got Unknown
		//IL_0035: Unknown result type (might be due to invalid IL or missing references)
		//IL_003f: Expected O, but got Unknown
		string password = Protected.getPassword();
		entry = new DirectoryEntry("LDAP://support.htb", "support\\ldap", password);
		entry.set_AuthenticationType((AuthenticationTypes)1);
		ds = new DirectorySearcher(entry);
	}

	public void query(string first, string last, bool verbose = false)
	{
		//IL_011e: Unknown result type (might be due to invalid IL or missing references)
		try
		{
			if (first == null && last == null)
			{
				Console.WriteLine("[-] At least one of -first or -last is required.");
				return;
			}
			string text = ((last == null) ? ("(givenName=" + first + ")") : ((first != null) ? ("(&(givenName=" + first + ")(sn=" + last + "))") : ("(sn=" + last + ")")));
			if (verbose)
			{
				Console.WriteLine("[*] LDAP query to use: " + text);
			}
			ds.set_Filter(text);
			ds.get_PropertiesToLoad().Add("sAMAccountName");
			SearchResultCollection val = ds.FindAll();
			if (val.get_Count() == 0)
			{
				Console.WriteLine("[-] No users identified with that query.");
				return;
			}
			if (verbose)
			{
				string text2 = "[+] Found " + val.get_Count() + " result";
				if (val.get_Count() > 1)
				{
					text2 += "s";
				}
				text2 += ":";
				Console.WriteLine(text2);
			}
			foreach (SearchResult item in val)
			{
				if (verbose)
				{
					Console.Write("       ");
				}
				Console.WriteLine(item.get_Properties().get_Item("sAMAccountName").get_Item(0));
			}
		}
		catch (Exception ex)
		{
			Console.WriteLine("[-] Exception: " + ex.Message);
		}
	}

	public void printUser(string username, bool verbose = false)
	{
		try
		{
			if (verbose)
			{
				Console.WriteLine("[*] Getting data for " + username);
			}
			ds.set_Filter("sAMAccountName=" + username);
			ds.get_PropertiesToLoad().Add("pwdLastSet");
			ds.get_PropertiesToLoad().Add("lastLogon");
			ds.get_PropertiesToLoad().Add("givenName");
			ds.get_PropertiesToLoad().Add("sn");
			ds.get_PropertiesToLoad().Add("mail");
			SearchResult val = ds.FindOne();
			if (val == null)
			{
				Console.WriteLine("[-] Unable to locate " + username + ". Please try the find command to get the user's username.");
				return;
			}
			if (((ReadOnlyCollectionBase)(object)val.get_Properties().get_Item("givenName")).Count > 0)
			{
				Console.WriteLine("First Name:           " + val.get_Properties().get_Item("givenName").get_Item(0));
			}
			if (((ReadOnlyCollectionBase)(object)val.get_Properties().get_Item("sn")).Count > 0)
			{
				Console.WriteLine("Last Name:            " + val.get_Properties().get_Item("sn").get_Item(0));
			}
			if (((ReadOnlyCollectionBase)(object)val.get_Properties().get_Item("mail")).Count > 0)
			{
				Console.WriteLine("Contact:              " + val.get_Properties().get_Item("mail").get_Item(0));
			}
			if (val.get_Properties().Contains("pwdLastSet"))
			{
				Console.WriteLine("Last Password Change: " + DateTime.FromFileTime((long)val.get_Properties().get_Item("pwdLastSet").get_Item(0)));
			}
		}
		catch (Exception ex)
		{
			Console.WriteLine("[-] Exception: " + ex.Message);
		}
	}
}
