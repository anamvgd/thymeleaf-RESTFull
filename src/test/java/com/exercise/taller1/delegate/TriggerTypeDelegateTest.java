package com.exercise.taller1.delegate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
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
import com.exercise.taller1.model.Triggertype;

import lombok.extern.log4j.Log4j2;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Taller1Application.class)
@Log4j2
public class TriggerTypeDelegateTest {
	
	@Mock
	private TriggerTypeDelegate autoDelegate;
	
	
	public TriggerTypeDelegateTest() {
		this.autoDelegate = new TriggerTypeDelegateImp();
	}
	
	@BeforeAll
	public static void setUp() {
		log.info("-----> AUTOTRANSITIONDELEGATE TESTS STARTED <-----");
	}
	
	@Nested
	@DisplayName("Save methods")
	class Save{
		
		@Test
		public void saveTriggerType_ValidCase() {

			Triggertype auto = new Triggertype();
			auto.setTrigtypeId(10);
			when(autoDelegate.findById(10)).thenReturn(auto);
			
			auto.setInstInstId(new BigDecimal(1));
			auto.setTrigtypeName("anafuriosa");
			autoDelegate.save(auto);

			assertEquals(autoDelegate.findById(10).getTrigtypeId(), auto.getTrigtypeId(), 
					"The IDs are different");

		}
		
		@Test
		public void saveTriggerType_ThrowError() {

			Triggertype auto = new Triggertype();
			auto.setTrigtypeId(10);
			when(autoDelegate.findById(10L)).thenReturn(auto);
			autoDelegate.save(auto);
			
			auto.setInstInstId(new BigDecimal(1));
			auto.setTrigtypeName("anafuriosa");
			
			
			Triggertype auto2 = new Triggertype();
		    auto2.setTrigtypeId(-10);
		    autoDelegate.save(auto2);
			
			
		    assertThrows(RuntimeException.class,() -> autoDelegate.findById(-10).getTrigtypeId(), 
					"Exception not thrown");

		}
			
			
			
		
		
	}
	
	@Nested
	@DisplayName("Edit methods")
	class Edit{
	
		@Test
		public void editTriggerType_DontChangeName() throws Exception {
			
			Triggertype auto = new Triggertype();
			auto.setTrigtypeId(10);
			auto.setTrigtypeName("anafuriosa");
			when(autoDelegate.findById(10)).thenReturn(auto);
			autoDelegate.save(auto);
			
			autoDelegate.edit(new BigDecimal(10), 10, "anapapada");
			
			
			
			assertNotEquals("anapapada",autoDelegate.findById(10).getTrigtypeName(),
					"The name are same");
			
		}
		
		@Test
		public void editTriggerType_DontChangeInstId() throws Exception {
			
			Triggertype auto = new Triggertype();
			auto.setTrigtypeId(10);
			auto.setTrigtypeName("anafuriosa");
			when(autoDelegate.findById(10)).thenReturn(auto);
			autoDelegate.save(auto);
			
			autoDelegate.edit(new BigDecimal(12), 10, "anapapada");
			
			
			
			assertNotEquals("FARFAR",autoDelegate.findById(10).getInstInstId(),
					"The isActive are same");
			
		}
		
		
		
	}
	
	
	@Nested
	@DisplayName("FindAll methods")
	class findAll{
		
		@Test
		public void findAllTriggerType_ValidCase() {
			
			Triggertype auto = new Triggertype();
			auto.setTrigtypeId(10);
			auto.setTrigtypeName("anafuriosa");
			Triggertype auto2 = new Triggertype();
			auto.setTrigtypeId(10);
			auto.setTrigtypeName("anafuriosa");
			
			ArrayList<Triggertype> returnL = new ArrayList<Triggertype>();
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
		public void findByIdTriggerType_ValidCase() {
			
			Triggertype auto = new Triggertype();
			auto.setTrigtypeId(10);
			auto.setTrigtypeName("anafuriosa");
			
			when(autoDelegate.findById(10)).thenReturn(auto);
			
			assertEquals(auto,autoDelegate.findById(10),
					"The object is different");
			
			
		}
		
		@Test
		public void findByIdTriggerType_InvalidCase() {
			
			Triggertype auto = new Triggertype();
			auto.setTrigtypeId(10);
			auto.setTrigtypeName("anafuriosa");
			
			
			
			assertThrows(RuntimeException.class,() -> autoDelegate.findById(10).getTrigtypeName(),
					"Exception not thrown");
			
			
		}
		
		
		
		
		
		
	}
	
	
	@AfterAll
	public static void finish() {
		log.info("-----> TASK TESTS FINISHED <-----");
	}

}
