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
import com.exercise.taller1.model.Triggerr;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Taller1Application.class)
@Log4j2
public class TriggerrDelegateTest {
	
	@Mock
	private TriggerDelegate autoDelegate;
	
	
	public TriggerrDelegateTest() {
		this.autoDelegate = new TriggerDelegateImp();
	}
	
	@BeforeAll
	public static void setUp() {
		log.info("-----> AUTOTRANSITIONDELEGATE TESTS STARTED <-----");
	}
	
	@Nested
	@DisplayName("Save methods")
	class Save{
		
		@Test
		public void saveTriggerr_ValidCase() {

			Triggerr auto = new Triggerr();
			auto.setTrigId(10);
			when(autoDelegate.findById(10)).thenReturn(auto);
			
			auto.setTrigScope("FARFAR");
			auto.setTrigName("anafuriosa");
			autoDelegate.save(auto);

			assertEquals(autoDelegate.findById(10).getTrigId(), auto.getTrigId(), 
					"The IDs are different");

		}
		
		@Test
		public void saveTriggerr_ThrowError() {

			Triggerr auto = new Triggerr();
			auto.setTrigId(10);
			when(autoDelegate.findById(10L)).thenReturn(auto);
			autoDelegate.save(auto);
			
			auto.setTrigScope("FARFAR");
			auto.setTrigName("anafuriosa");
			
			
			Triggerr auto2 = new Triggerr();
		    auto2.setTrigId(-10);
		    autoDelegate.save(auto2);
			
			
		    assertThrows(RuntimeException.class,() -> autoDelegate.findById(-10).getTrigId(), 
					"Exception not thrown");

		}
			
			
			
		
		
	}
	
	@Nested
	@DisplayName("Edit methods")
	class Edit{
	
		@Test
		public void editTrigger_DontChangeName() throws Exception {
			
			Triggerr auto = new Triggerr();
			auto.setTrigId(10);
			auto.setTrigName("anafuriosa");
			when(autoDelegate.findById(10)).thenReturn(auto);
			autoDelegate.save(auto);
			
			autoDelegate.edit(10, "anapapada", "FARFAR");
			
			
			
			assertNotEquals("anapapada",autoDelegate.findById(10).getTrigName(),
					"The name are same");
			
		}
		
		@Test
		public void editTriggerr_DontChangeScope() throws Exception {
			
			Triggerr auto = new Triggerr();
			auto.setTrigId(10);
			auto.setTrigName("anafuriosa");
			auto.setTrigScope("FAR");
			when(autoDelegate.findById(10)).thenReturn(auto);
			autoDelegate.save(auto);
			
			autoDelegate.edit(10, "anapapada", "FARFAR");
			
			
			
			assertNotEquals("FARFAR",autoDelegate.findById(10).getTrigScope(),
					"The isActive are same");
			
		}
		
		
		
	}
	
	
	@Nested
	@DisplayName("FindAll methods")
	class findAll{
		
		@Test
		public void findAllTriggerr_ValidCase() {
			
			Triggerr auto = new Triggerr();
			auto.setTrigId(10);
			auto.setTrigName("anafuriosa");
			auto.setTrigScope("FARFAR");
			Triggerr auto2 = new Triggerr();
			auto.setTrigId(10);
			auto.setTrigName("anafuriosa");
			auto.setTrigScope("FARFAR");
			
			ArrayList<Triggerr> returnL = new ArrayList<Triggerr>();
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
		public void findByIdTrigger_ValidCase() {
			
			Triggerr auto = new Triggerr();
			auto.setTrigId(10);
			auto.setTrigName("anafuriosa");
			auto.setTrigScope("FARFAR");
			
			when(autoDelegate.findById(10)).thenReturn(auto);
			
			assertEquals(auto,autoDelegate.findById(10),
					"The object is different");
			
			
		}
		
		@Test
		public void findByIdTrigger_InvalidCase() {
			
			Triggerr auto = new Triggerr();
			auto.setTrigId(10);
			auto.setTrigName("anafuriosa");
			auto.setTrigScope("FARFAR");
			
			
			
			assertThrows(RuntimeException.class,() -> autoDelegate.findById(10).getTrigName(),
					"Exception not thrown");
			
			
		}
		
		
		
		
		
		
	}
	
	
	@AfterAll
	public static void finish() {
		log.info("-----> TASK TESTS FINISHED <-----");
	}
	

}
