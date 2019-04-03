package lessons.tests.addressbook.tests;


import lessons.tests.addressbook.model.ContactData;
import lessons.tests.addressbook.model.Contacts;
import org.testng.annotations.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;



public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() throws Exception {
    Contacts before = (Contacts) app.contact().allc();
    ContactData contactData = new ContactData().withFirstname("Santa").withLastname("Claus").withCompany("North").withHome("234567").withMobile("020000").withWork("1111111").withEmail("santa@test.com").withGroup("test");
    app.contact().createContact(contactData);
    Contacts after= (Contacts) app.contact().allc();
    assertThat(after.size(), equalTo( + 1));

    assertThat(after, equalTo(
            before.withAddedc( contactData.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }


}
