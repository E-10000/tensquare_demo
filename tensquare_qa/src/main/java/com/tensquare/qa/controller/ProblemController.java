package com.tensquare.qa.controller;
import java.util.List;
import java.util.Map;

<<<<<<< HEAD
=======
import com.tensquare.qa.clitnt.LabelClient;
>>>>>>> ed90e21... v1.0.0
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.tensquare.qa.pojo.Problem;
import com.tensquare.qa.service.ProblemService;

import entity.PageResult;
import entity.Result;
import entity.StatusCode;
/**
 * 控制器层
 * @author Administrator
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/problem")
public class ProblemController {

	@Autowired
	private ProblemService problemService;
<<<<<<< HEAD
	
=======

	@Autowired
	private LabelClient labelClient;
>>>>>>> ed90e21... v1.0.0
	
	/**
	 * 查询全部数据
	 * @return
	 */
	@GetMapping("")
	public Result findAll(){
		return new Result(true,StatusCode.OK,"查询成功",problemService.findAll());
	}
	
	/**
	 * 根据ID查询
	 * @param id ID
	 * @return
	 */
	@GetMapping("{id}")
	public Result findById(@PathVariable String id){
		return new Result(true,StatusCode.OK,"查询成功",problemService.findById(id));
	}


	/**
	 * 分页+多条件查询
	 * @param searchMap 查询条件封装
	 * @param page 页码
	 * @param size 页大小
	 * @return 分页结果
	 */
	@PostMapping("search/{page}/{size}")
	public Result findSearch(@RequestBody Map searchMap , @PathVariable int page, @PathVariable int size){
		Page<Problem> pageList = problemService.findSearch(searchMap, page, size);
		return  new Result(true,StatusCode.OK,"查询成功",  new PageResult<Problem>( pageList.getTotalElements(), pageList.getContent()) );
	}

	/**
     * 根据条件查询
     * @param searchMap
     * @return
     */
	@PostMapping("search")
    public Result findSearch( @RequestBody Map searchMap){
        return new Result(true,StatusCode.OK,"查询成功",problemService.findSearch(searchMap));
    }
	
	/**
	 * 增加
	 * @param problem
	 */
	@PostMapping("")
	public Result add(@RequestBody Problem problem  ){
		problemService.add(problem);
		return new Result(true,StatusCode.OK,"增加成功");
	}
	
	/**
	 * 修改
	 * @param problem
	 */
	@PutMapping("{id}")
	public Result update(@RequestBody Problem problem, @PathVariable String id ){
		problem.setId(id);
		problemService.update(problem);		
		return new Result(true,StatusCode.OK,"修改成功");
	}
	
	/**
	 * 删除
	 * @param id
	 */
	@DeleteMapping("{id}")
	public Result delete(@PathVariable String id ){
		problemService.deleteById(id);
		return new Result(true,StatusCode.OK,"删除成功");
	}

	@GetMapping("newlist/{labelid}/{page}/{size}")
	public Result newList(@PathVariable("labelid") String labelid,@PathVariable int page,@PathVariable int size){
		Page<Problem> problems = problemService.newList(labelid, page, size);
		return new Result(true,StatusCode.OK,"查找成功",new PageResult(problems.getTotalElements(),problems.getContent()));
	}

	@GetMapping("hotlist/{labelid}/{page}/{size}")
	public Result hotList(@PathVariable("labelid") String labelid,@PathVariable int page,@PathVariable int size){
		Page<Problem> problems = problemService.hotList(labelid, page, size);
		return new Result(true,StatusCode.OK,"查找成功",new PageResult(problems.getTotalElements(),problems.getContent()));
	}

	@GetMapping("waitlist/{labelid}/{page}/{size}")
	public Result waitList(@PathVariable("labelid") String labelid,@PathVariable int page,@PathVariable int size){
		Page<Problem> problems = problemService.waitList(labelid, page, size);
		return new Result(true,StatusCode.OK,"查找成功",new PageResult( problems.getTotalElements(),problems.getContent()));
	}
<<<<<<< HEAD
=======

	//localhost:9003/problem/label/{labelId}
	@GetMapping("label/{labelId}")
	public Result findLabelById(@PathVariable("labelId") String labelId){
		Result result = labelClient.findById(labelId);
		return result;
	}
>>>>>>> ed90e21... v1.0.0
	
}
