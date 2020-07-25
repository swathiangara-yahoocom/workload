package com.wawa.workloadmanagement;

import com.wawa.workloadmanagement.model.Employee;
import com.wawa.workloadmanagement.model.WawaStation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StationController {

    @Autowire
    StationManagerService stationManagerService;

    @RequestMapping("/loginStation")
    public boolean loginStation(@QueryParam Integer stationId, @QueryParam String stationName @QueryParam Integer employeeId) {

        WawaStation wasva = new WawaStation(stationId, stationName, new ArrayList<Employee>().add(new Employee(employeeId)) );

        return stationManagerService.employyeLogin(wasva);


    }
}
