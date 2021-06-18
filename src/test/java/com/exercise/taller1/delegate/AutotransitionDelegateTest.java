package com.exercise.taller1.delegate;

import static org.junit.jupiter.api.Assertions.*;
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
import com.exercise.taller1.model.Autotransition;

import lombok.extern.log4j.Log4j2;


@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Taller1Application.class)
@Log4j2
public class AutotransitionDelegateTest {
	
	@Mock
	private AutotransitionDelegate autoDelegate;
	
	
	public AutotransitionDelegateTest() {
		this.autoDelegate = new AutotransitionDelegateImp();
	}
	
	@BeforeAll
	public static void setUp() {
		log.info("-----> AUTOTRANSITIONDELEGATE TESTS STARTED <-----");
	}
	
	@Nested
	@DisplayName("Save methods")
	class Save{
		
		@Test
		public void saveAutotransition_ValidCase() {

			Autotransition auto = new Autotransition();
			auto.setAutotranId(10);
			when(autoDelegate.findById(10)).thenReturn(auto);
			
			auto.setAutotranIsactive("Y");
			auto.setAutotranLogicaloperand("AND");
			auto.setAutotranName("anafuriosa");
			autoDelegate.save(auto);

			assertEquals(autoDelegate.findById(10).getAutotranId(), auto.getAutotranId(), 
					"The IDs are different");

		}
		
		@Test
		public void saveAutotransition_ThrowError() {

			Autotransition auto = new Autotransition();
			auto.setAutotranId(10);
			when(autoDelegate.findById(10L)).thenReturn(auto);
			autoDelegate.save(auto);
			
			auto.setAutotranIsactive("Y");
			auto.setAutotranLogicaloperand("AND");
			auto.setAutotranName("anafuriosa");
			
			
		    Autotransition auto2 = new Autotransition();
		    auto2.setAutotranId(-10);
		    autoDelegate.save(auto2);
			
			
		    assertThrows(RuntimeException.class,() -> autoDelegate.findById(-10).getAutotranId(), 
					"Exception not thrown");

		}
		
		
			
			
			
			
			
			
			
			
		
		
	}
	
	@Nested
	@DisplayName("Edit methods")
	class Edit{
	
		@Test
		public void editAutotransition_DontChangeName() throws Exception {
			
			Autotransition auto = new Autotransition();
			auto.setAutotranId(10);
			auto.setAutotranName("anafuriosa");
			when(autoDelegate.findById(10)).thenReturn(auto);
			autoDelegate.save(auto);
			
			autoDelegate.edit(10, "anapapada", "Y", "AND");
			
			
			
			assertNotEquals("anapapada",autoDelegate.findById(10).getAutotranName(),
					"The name are same");
			
		}
		
		@Test
		public void editAutotransition_DontChangeIsActive() throws Exception {
			
			Autotransition auto = new Autotransition();
			auto.setAutotranId(10);
			auto.setAutotranName("anafuriosa");
			auto.setAutotranIsactive("N");
			when(autoDelegate.findById(10)).thenReturn(auto);
			autoDelegate.save(auto);
			
			autoDelegate.edit(10, "anapapada", "Y", "AND");
			
			
			
			assertNotEquals("Y",autoDelegate.findById(10).getAutotranIsactive(),
					"The isActive are same");
			
		}
		
		@Test
		public void editAutotransition_DontChangeLogicalOperator() throws Exception {
			
			Autotransition auto = new Autotransition();
			auto.setAutotranId(10);
			auto.setAutotranName("anafuriosa");
			auto.setAutotranLogicaloperand("OR");
			when(autoDelegate.findById(10)).thenReturn(auto);
			autoDelegate.save(auto);
			
			autoDelegate.edit(10, "anapapada", "Y", "AND");
			
			
			
			assertNotEquals("AND",autoDelegate.findById(10).getAutotranLogicaloperand(),
					"The logicalOperand are same");
			
		}
		
		
	}
	
	
	@Nested
	@DisplayName("FindAll methods")
	class findAll{
		
		@Test
		public void findAllAutotransition_ValidCase() {
			
			Autotransition auto = new Autotransition();
			auto.setAutotranId(10);
			auto.setAutotranName("anafuriosa");
			auto.setAutotranLogicaloperand("OR");
			Autotransition auto2 = new Autotransition();
			auto.setAutotranId(11);
			auto.setAutotranName("anafuriosa");
			auto.setAutotranLogicaloperand("OR");
			
			ArrayList<Autotransition> returnL = new ArrayList<Autotransition>();
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
		public void findByIdAutotransition_ValidCase() {
			
			Autotransition auto = new Autotransition();
			auto.setAutotranId(10);
			auto.setAutotranName("anafuriosa");
			auto.setAutotranLogicaloperand("OR");
			
			when(autoDelegate.findById(10)).thenReturn(auto);
			
			assertEquals(auto,autoDelegate.findById(10),
					"The object is different");
			
			
		}
		
		@Test
		public void findByIdAutotransition_InvalidCase() {
			
			Autotransition auto = new Autotransition();
			auto.setAutotranId(10);
			auto.setAutotranName("anafuriosa");
			auto.setAutotranLogicaloperand("OR");
			
			
			
			assertThrows(RuntimeException.class,() -> autoDelegate.findById(10).getAutotranName(),
					"Exception not thrown");
			
			
		}
		
		
		
		
		
		
	}
	
	
	@AfterAll
	public static void finish() {
		log.info("-----> TASK TESTS FINISHED <-----");
	}
	
	
	
	

}
