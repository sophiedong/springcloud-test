package com.example;

import com.yylc.platform.common.base.QueryResult;
import com.yylc.prodcore.common.service.api.ProductQueryService;
import com.yylc.prodcore.common.service.model.FinancialProduct;
import com.yylc.prodcore.common.service.query.FinancialProductQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class HelloController {

    @Autowired
    private ProductQueryService productQueryService;

    @RequestMapping("/")
    public Object index(){

        FinancialProductQuery query = new FinancialProductQuery();
        query.setTypeCode("001");
        List<String> statuses = new ArrayList<String>();
        statuses.add("FORSALE");
        query.setStatuses(statuses);
        QueryResult<List<FinancialProduct>> result = productQueryService.getProductList(query);
        return  result;
    }
}
