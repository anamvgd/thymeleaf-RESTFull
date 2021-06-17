package com.exercise.taller1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

import com.exercise.taller1.model.Autotransition;
import com.exercise.taller1.model.FevInstitution;
import com.exercise.taller1.model.Triggerr;
import com.exercise.taller1.model.Triggertype;
import com.exercise.taller1.model.Userr;
import com.exercise.taller1.model.UserrType;
import com.exercise.taller1.model.Userselect;
import com.exercise.taller1.service.AutotransitionService;
import com.exercise.taller1.service.FevInstitutionService;
import com.exercise.taller1.service.TriggerService;
import com.exercise.taller1.service.TriggerTypeService;
import com.exercise.taller1.service.UserSelectService;
import com.exercise.taller1.service.UserrService;

@SpringBootApplication
public class Taller1Application {

	@Bean
	public Java8TimeDialect java8TimeDialect() {
		return new Java8TimeDialect();
	}

	public static void main(String[] args) {
		SpringApplication.run(Taller1Application.class, args);
	}

	@Bean
	public CommandLineRunner dummy(UserrService userrServ, FevInstitutionService fevServ,
			AutotransitionService autotranServ, TriggerTypeService triggerTypeService, TriggerService triggerrService,
			UserSelectService userSelectService) {
		return (args) -> {
			Userr userr1 = new Userr();
			userr1.setUserName("Jose");
			userr1.setType(UserrType.administrador);
			userr1.setUserPassword("{noop}12345678");
			userrServ.save(userr1);

			Userr userr2 = new Userr();
			userr2.setUserName("Jose2");
			userr2.setType(UserrType.operador);
			userr2.setUserPassword("{noop}12345678");
			userrServ.save(userr2);

			FevInstitution fevInst = new FevInstitution();
			fevInst.setInstName("Icesi");
			fevServ.add(fevInst);

			Autotransition autotran = new Autotransition();
			autotran.setAutotranName("asdasd");
			autotran.setAutotranLogicaloperand("AND");
			autotran.setAutotranIsactive("N");
			autotranServ.save(autotran);

			Triggertype trigType1 = new Triggertype();
			trigType1.setTrigtypeName("Trig1");
			triggerTypeService.save(trigType1);

			Triggerr triggerr = new Triggerr();
			triggerr.setTrigScope("asdasd");
			triggerr.setTrigName("asdasd");
			triggerr.setTriggertype(trigType1);
			triggerrService.save(triggerr);
			
			Triggerr triggerr2 = new Triggerr();
			triggerr2.setTrigScope("L");
			triggerr2.setTrigName("asdasd");
			triggerr2.setTriggertype(trigType1);
			triggerrService.save(triggerr2);

			Userselect userselect = new Userselect();
			userselect.setTriggerr(triggerr);
			userselect.setUsselTablename("1");
			userselect.setUsselValuekeycolumn("1");
			userselect.setUsselValueusercolumn("1");
			userselect.setUsselWherestatement("Calf");
			userSelectService.save(userselect);
		};
	}
}