package com.bee.study.controller.api;

import com.bee.study.entity.User;
import com.bee.study.service.UserService;
import com.bee.study.util.BaseSearch;
import com.bee.study.util.ResponseEntityDto;
import com.bee.study.util.SearchFilters;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


/**
 * Created by liangbe on 2017/3/31.
 */


@RestController
@RequestMapping("/api/user")
public class SampleController {


    @Autowired
    UserService userService;

    @RequestMapping( method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> sayWorld(@RequestParam("searchFilters")
                                                  String searchFiltersString,
                                      @RequestParam("page") int  page,
                                      @RequestParam("start") int start,
                                      @RequestParam("limit") int limit
                                      )
    {

        JSONArray myJsonArray= JSONArray.fromObject(searchFiltersString);
        Collection collection = JSONArray.toCollection(myJsonArray, SearchFilters.class);
        List<SearchFilters> searchFiltersList=new ArrayList<SearchFilters>();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            SearchFilters searchFilter = (SearchFilters) it.next();
            searchFiltersList.add(searchFilter);
        }
//        JSONObject jsStr = JSONObject.fromObject(searchFiltersString);

        BaseSearch<User> baseSearch=new BaseSearch<User>(searchFiltersList);
        List<User> entities=userService.findAll(baseSearch);
        return new ResponseEntity<Object>(new ResponseEntityDto(entities), HttpStatus.OK);
    }
}
