package vn.techmaster.peopledata.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.techmaster.peopledata.model.Person;
import vn.techmaster.peopledata.repository.PersonRepository;

@RestController
@RequestMapping("/")
public class PeopleController {
  @Autowired private PersonRepository personRepo;
  
  @GetMapping("groupbycity")
  public ResponseEntity<Map<String, List<Person>>> groupByCity() {
    return ResponseEntity.ok().body(personRepo.groupPeopleByCity());
  }

  @GetMapping("groupbycitythencount")
  public ResponseEntity<Map<String, Long>> groupByCityThenCount() {
    return ResponseEntity.ok().body(personRepo.groupByCityThenCount());
  }

  @GetMapping("groupbyjobthencount")
  public ResponseEntity<Map<String, Long>> groupByJobThenCount() {
    return ResponseEntity.ok().body(personRepo.groupByJobThenCount());
  }

  @GetMapping("fivetopjobs")
  public ResponseEntity<Map<String, Long>> fiveTopJobs(){
    return ResponseEntity.ok().body(personRepo.fiveTopJobs());
  }

  @GetMapping("fivetoppopcities")
  public ResponseEntity<Map<String, Long>> fiveTopPopulationCities() {
    return ResponseEntity.ok().body(personRepo.fiveTopPopulationCities());
  }

  //2.5 Trong mỗi thành phố, hãy tìm ra nghề nào được làm nhiều nhất
  @GetMapping("topjobcity")
  public ResponseEntity<Map<String, Map.Entry<String, Long>>> topJobByNumerInEachCity() {
    return ResponseEntity.ok().body(personRepo.topJobByNumerInEachCity());
  }

  //2.6 Ứng với một nghề, hãy tính mức lương trung bình
  @GetMapping("averagesalary")
  public ResponseEntity<Map<String, Double>> averageSalaryByJob() {
    return ResponseEntity.ok().body(personRepo.averageSalaryByJob());
  }

  //2.7 Năm thành phố có mức lương trung bình cao nhất
  @GetMapping("5citistopsalary")
  public ResponseEntity<List<Map.Entry<String,Double>>> fiveCitiesHasTopAverageSalary() {
    return ResponseEntity.ok().body(personRepo.fiveCitiesHasTopAverageSalary());
  }

  //2.8 Năm thành phố có mức lương trung bình của developer cao nhất
  @GetMapping("5citistopdevsalary")
  public ResponseEntity<List<Map.Entry<String,Double>>> fiveCitiesHasTopSalaryForDeveloper() {
    return ResponseEntity.ok().body(personRepo.fiveCitiesHasTopSalaryForDeveloper());
  }

  //2.9 Tuổi trung bình từng nghề nghiệp
  @GetMapping("averageageperjob")
  public ResponseEntity<Map<String, Double>> averageAgePerJob() {
    return ResponseEntity.ok().body(personRepo.averageAgePerJob());
  }

  //2.11 Tuổi cao nhất ở mỗi thành phố
  @GetMapping("maxagepercity")
  public ResponseEntity<List<Map.Entry<String, Integer>>> maxAgePerCity() {
    return ResponseEntity.ok().body(personRepo.maxAgePerCity());
  }

  //2.12 tỷ lệ nam / nữ trong toàn bộ dữ liệu
  @GetMapping("malefemaleratio")
  public ResponseEntity<Double> maleFemaleRatio() {
    return ResponseEntity.ok().body(personRepo.maleFemaleRatio());
  }

  //2.13
  @GetMapping("developerListInCity")
  public ResponseEntity<Map<String, List<Person>>> developerListInCity() {
    return ResponseEntity.ok().body(personRepo.developerListInCity());
  }
  //2.14
  @GetMapping("youngestdevs")
  public ResponseEntity<Map.Entry<String, Double>>  cityHasHighestAgeDeveloper() {
    return ResponseEntity.ok().body(personRepo.youngestdevs());
  }
  //2.15
  @GetMapping("malefemaleratioEachCity")
  public ResponseEntity<Map<String, Map<String, Long>> >  malefemaleratioEachCity() {
    return ResponseEntity.ok().body(personRepo.malefemaleratioEachCity());
  }

  //2.16
  @GetMapping("avgsalarypeopleabove30")
  public ResponseEntity<Double>  avgsalarypeopleabove30() {
    return ResponseEntity.ok().body(personRepo.avgsalarypeopleabove30());
  }
}
