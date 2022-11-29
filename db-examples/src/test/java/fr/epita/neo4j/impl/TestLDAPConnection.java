package fr.epita.neo4j.impl;

import org.junit.jupiter.api.Test;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import java.util.Hashtable;

public class TestLDAPConnection {


    @Test
    public void test() throws NamingException {
        //Authentication
        Hashtable<String, String> ldapEnv = new Hashtable<String, String>(11);
        ldapEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");

        ldapEnv.put(Context.PROVIDER_URL,  "ldap://localhost:10389");
        ldapEnv.put(Context.SECURITY_AUTHENTICATION, "simple");

        ldapEnv.put(Context.SECURITY_PRINCIPAL, "uid=admin,ou=system");
        ldapEnv.put(Context.SECURITY_CREDENTIALS, "secret");
        DirContext ldapContext = new InitialDirContext(ldapEnv);

        //Search
        SearchControls searchCtls = new SearchControls();

        //Specify the attributes to return
        String returnedAtts[]={"sn","dn"};
        searchCtls.setReturningAttributes(returnedAtts);

        //Specify the search scope
        searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);

        //specify the LDAP search filter
        String searchFilter = "(&(objectClass=inetOrgPerson)(sn=sidi))";


        String searchBase = "dc=example,dc=com";

        NamingEnumeration<SearchResult> answer = ldapContext.search(searchBase, searchFilter, searchCtls);

        answer.asIterator().forEachRemaining(s -> System.out.println(s.getName()));

        //take the dn found



    }
}
