package com.exercise.taller1.delegate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.exercise.taller1.Taller1Application;
import com.exercise.taller1.model.Userselect;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Taller1Application.class)
@Log4j2
public class UserSelectDelegateTest {

	@Mock
	private UserrSelectDelegate autoDelegate;
	
	
	public UserSelectDelegateTest() {
		this.autoDelegate = new UserrSelectDelegateImp();
	}
	
	@BeforeAll
	public static void setUp() {
		log.info("-----> AUTOTRANSITIONDELEGATE TESTS STARTED <-----");
	}
	
	@Nested
	@DisplayName("Save methods")
	class Save{
		
		@Test
		public void saveUserSelect_ValidCase() {

			Userselect auto = new Userselect();
			auto.setUsselId(10);
			when(autoDelegate.findById(10)).thenReturn(auto);
			
			auto.setUsselTablename("ASDASD");
			auto.setUsselValueusercolumn("anafuriosa");
			autoDelegate.save(auto);

			assertEquals(autoDelegate.findById(10).getUsselId(), auto.getUsselId(), 
					"The IDs are different");

		}
		
		@Test
		public void saveUserSelect_ThrowError() {

			Userselect auto = new Userselect();
			auto.setUsselId(10);
			when(autoDelegate.findById(10)).thenReturn(auto);
			autoDelegate.save(auto);
			
			auto.setUsselTablename("ASDASD");
			auto.setUsselValueusercolumn("anafuriosa");
			
			
			Userselect auto2 = new Userselect();
		    auto2.setUsselId(-10);
		    autoDelegate.save(auto2);
			
			
		    assertThrows(RuntimeException.class,() -> autoDelegate.findById(-10).getUsselId(), 
					"Exception not thrown");

		}
			
			
			
		
		
	}
	
	@Nested
	@DisplayName("Edit methods")
	class Edit{
	
		@Test
		public void editUserSelect_DontChangeName() throws Exception {
			
			Userselect auto = new Userselect();
			auto.setUsselId(10);
			auto.setUsselTablename("anafuriosa");
			when(autoDelegate.findById(10)).thenReturn(auto);
			autoDelegate.save(auto);
			
			autoDelegate.edit(10, "anapapada","asdasd","asasd","adasd");
			
			
			
			assertNotEquals("anapapada",autoDelegate.findById(10).getUsselTablename(),
					"The name are same");
			
		}
		
		@Test
		public void editUserSelect_DontChangeValueKey() throws Exception {
			
			Userselect auto = new Userselect();
			auto.setUsselId(10);
			auto.setUsselTablename("anafuriosa");
			auto.setUsselValuekeycolumn("farasd");
			when(autoDelegate.findById(10)).thenReturn(auto);
			autoDelegate.save(auto);
			
			autoDelegate.edit(10, "anapapada","asdasd","asasd","adasd");
			
			
			
			assertNotEquals("asdasd",autoDelegate.findById(10).getUsselValuekeycolumn(),
					"The isActive are same");
			
		}
		
		@Test
		public void editUserSelect_DontChangeValueUser() throws Exception {
			
			Userselect auto = new Userselect();
			auto.setUsselId(10);
			auto.setUsselTablename("anafuriosa");
			auto.setUsselValueusercolumn("farasd");
			when(autoDelegate.findById(10)).thenReturn(auto);
			autoDelegate.save(auto);
			
			autoDelegate.edit(10, "anapapada","asdasd","asasd","adasd");
			
			
			
			assertNotEquals("asasd",autoDelegate.findById(10).getUsselValueusercolumn(),
					"The isActive are same");
			
		}
		
		@Test
		public void editUserSelect_DontChangeStatement() throws Exception {
			
			Userselect auto = new Userselect();
			auto.setUsselId(10);
			auto.setUsselTablename("anafuriosa");
			auto.setUsselWherestatement("farasd");
			when(autoDelegate.findById(10)).thenReturn(auto);
			autoDelegate.save(auto);
			
			autoDelegate.edit(10, "anapapada","asdasd","asasd","adasd");
			
			
			
			assertNotEquals("adasd",autoDelegate.findById(10).getUsselWherestatement(),
					"The isActive are same");
			
		}
		
		
	}
	
	
	@Nested
	@DisplayName("FindAll methods")
	class findAll{
		
		@Test
		public void findAllUserSelect_ValidCase() {
			
			Userselect auto = new Userselect();
			auto.setUsselId(10);
			auto.setUsselTablename("anafuriosa");
			Userselect auto2 = new Userselect();
			auto.setUsselId(11);
			auto.setUsselTablename("anafuriosa");
			
			ArrayList<Userselect> returnL = new ArrayList<Userselect>();
			returnL.add(auto);
			returnL.add(auto2);
			when(autoDelegate.findAll()).thenReturn(returnL);
			
			assertEquals(returnL,autoDelegate.findAll(),
					"The list are different");
			
			
		}		
		
		
	}
	
	
	@Nested
	@DisplayName("FindById methods")
	class findById{
		

		@Test
		public void findByIdUserSelect_ValidCase() {
			
			Userselect auto = new Userselect();
			auto.setUsselId(10);
			auto.setUsselTablename("anafuriosa");
			
			when(autoDelegate.findById(10)).thenReturn(auto);
			
			assertEquals(auto,autoDelegate.findById(10),
					"The object is different");
			
			
		}
		
		@Test
		public void findByIdUserSelect_InvalidCase() {
			
			Userselect auto = new Userselect();
			auto.setUsselId(10);
			auto.setUsselTablename("anafuriosa");
			
			
			
			assertThrows(RuntimeException.class,() -> autoDelegate.findById(10).getUsselTablename(),
					"Exception not thrown");
			
			
		}
		
		
		
		
		
		
	}
	
	
	@AfterAll
	public static void finish() {
		log.info("-----> TASK TESTS FINISHED <-----");
	}
}
