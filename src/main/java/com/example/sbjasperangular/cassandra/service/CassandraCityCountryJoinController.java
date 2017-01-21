package com.example.sbjasperangular.cassandra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sbjasperangular.cassandra.model.CassandraCityCountry;



@RestController
@RequestMapping("rest/cassandra/city_country_join")
public class CassandraCityCountryJoinController {

	@Autowired
	CassandraCityCountryJoinService service;

	// curl http://localhost:8080/rest/cassandra/city_country_join -i -XGET
	// OK
	@GetMapping
	List<CassandraCityCountry> getCassandraCityCountrys() {
        List<CassandraCityCountry> list = service.findAll();
        return list;
    }
//
//	// 全件抽出
//	// curl http://localhost:8080/rest/cassandra/memobox/byname -i -XGET
//	// OK
//	@GetMapping("byname")
//	List<MemoBox> getMemoBoxsAllByName() {
//        List<MemoBox> memoboxs = service.findAllByName();
//        return memoboxs;
//    }
//
//	// memo指定検索
//	// curl http://localhost:8080/rest/cassandra/memobox/bymemo/memo1 -i -XGET
//	// ?
//	@GetMapping(path = "bymemo/{memo}")
//	List<MemoBox> getMemoBoxsByName(@PathVariable String memo) {
//        List<MemoBox> memoboxs = service.findByMemo(memo);
//        return memoboxs;
//    }
//
//	// 選択
//	// curl http://localhost:8080/rest/cassandra/memobox/4622f8d0-c8bd-11e6-b218-2f92b65bfc29 -i -XGET
//	// OK
//    @GetMapping(path = "{id}")
//    MemoBox getMemoBoxById(@PathVariable UUID id) {
//    	MemoBox MemoBox = service.findOne(id);
//        return MemoBox;
//    }
//
//    // 新規登録
//    // curl http://localhost:8080/rest/cassandra/memobox -i -XPOST -H "Content-Type: application/json"
//    // -d "{\"pkey1\":\"a\",\"pkey2\":\"b\",\"id\":\"93d5db10-c9ad-11e6-b26a-27c9d3fa31b8\",\"name\":\"asai\",\"memo\":\"memo1\",\"date\":\"1482565802817\"}"
//	// OK
//    @PostMapping
//    ResponseEntity<MemoBox> postMemoBox(@RequestBody MemoBox memobox, UriComponentsBuilder uriBuilder) {
//    	MemoBox created = service.create(memobox);
//        URI location = uriBuilder.path("rest/cassandra/memobox/{id}")
//                .buildAndExpand(created.getId()).toUri();
//        return ResponseEntity.created(location).body(created);
//    }
//
//    // 更新
//    // curl http://localhost:8080/rest/cassandra/memobox/4622f8d0-c8bd-11e6-b218-2f92b65bfc29 -i -XPUT -H "Content-Type:
//    // application/json" -d "{\"pkey1\":\"a\",\"pkey2\":\"b\",\"id\":\"4622f8d0-c8bd-11e6-b218-2f92b65bfc29\",\"name\":\"tanaka\",\"memo\":\"greet messageA\",\"date\":\"1482565233349\"}"
//    // OK
//    @PutMapping(path = "{id}")
//    MemoBox putMemoBox(@PathVariable UUID id, @RequestBody MemoBox memobox) {
//    	memobox.setId(id);
//        return service.update(memobox);
//    }
//
//    // 削除
//    // curl http://localhost:8080/rest/cassandra/memobox/4067ef50-c9ac-11e6-b26a-27c9d3fa31b8 -i -XDELETE
//    // OK
//    @DeleteMapping(path = "{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    void deleteCustomer(@PathVariable UUID id) {
//    	service.delete(id);
//    }

}
