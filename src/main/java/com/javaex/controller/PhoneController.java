package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller // Dao --> @Repository
// @RequestMapping(value="/pb")
public class PhoneController {
	
	//필드
	@Autowired
	private PhoneDao phoneDao;

	//리스트
	@RequestMapping( value="list", method= {RequestMethod.GET, RequestMethod.POST} )
	public String list(Model model) {
		System.out.println("[PhoneController.list]");
		
		//PhoneDao phoneDao = new PhoneDao(); --> @Autowired
		List<PersonVo> personList = phoneDao.getPersonList();
		System.out.println(personList);
		
		model.addAttribute("personList", personList);
		
		return "/WEB-INF/views/list.jsp";
	}
	
	// 쓰기폼
	@RequestMapping( value="writeForm", method= {RequestMethod.GET, RequestMethod.POST} )
	public String writeForm() {
		System.out.println("[PhoneController.writeForm]");
		
		return "/WEB-INF/views/writeForm.jsp";
	}
	
	// 쓰기
	@RequestMapping( value="write", method= {RequestMethod.GET, RequestMethod.POST} )
	public String write(@ModelAttribute PersonVo personVo) {
		System.out.println("[PhoneController.write]");
		System.out.println(personVo);
		
		//PhoneDao phoneDao = new PhoneDao(); --> @Autowired
		phoneDao.personInsert(personVo);
		
		return "redirect:/list";
	}
	
	// 삭제
	@RequestMapping( value="delete", method= {RequestMethod.GET, RequestMethod.POST} )
	public String delete(@RequestParam("personId") int personId) {
		System.out.println("[PhoneController.delete]");
		
		//PhoneDao phoneDao = new PhoneDao(); --> @Autowired
		phoneDao.personDelete(personId);
		
		return "redirect:/list";
	}
	
	// 수정폼
	@RequestMapping( value="updateForm", method= {RequestMethod.GET, RequestMethod.POST} )
	public String updateForm(Model model, @RequestParam("personId") int personId) {
		System.out.println("[PhoneController.updateForm]");
		
		//PhoneDao phoneDao = new PhoneDao(); --> @Autowired
		PersonVo personVo = phoneDao.getPerson(personId);
		model.addAttribute("personInfo", personVo);
		
		return "/WEB-INF/views/updateForm.jsp";
	}
	
	// 수정
	@RequestMapping( value="update", method= {RequestMethod.GET, RequestMethod.POST} )
	public String update(@ModelAttribute PersonVo personVo) {
		System.out.println("[PhoneController.update]");
		//PhoneDao phoneDao = new PhoneDao(); --> @Autowired
		phoneDao.personUpdate(personVo);
		
		return "redirect:/list";
	}
	
	
	/*
	//파라미터가 있을때도 있고 없을떄고 있고
	@RequestMapping( value="write", method= {RequestMethod.GET, RequestMethod.POST} )
	public String write(@RequestParam("name") String name,
						@RequestParam("hp") String hp,
						@RequestParam(value="company", required=false, defaultValue="회사안다님") String company) {
		System.out.println("[PhoneController.write]");
		System.out.println(name);
		System.out.println(hp);
		System.out.println(company);
		
		PersonVo personVo = new PersonVo(name, hp, company);
		System.out.println(personVo);
		
		return "/WEB-INF/views/write.jsp";
	}
	*/
	
	/*
	// 파라미터를 1개씩 받을때
	@RequestMapping( value="write", method= {RequestMethod.GET, RequestMethod.POST} )
	public String write(@RequestParam("name") String name,
						@RequestParam("hp") String hp,
						@RequestParam("company") String company) {
		System.out.println("[PhoneController.write]");
		System.out.println(name);
		System.out.println(hp);
		System.out.println(company);
		
		PersonVo personVo = new PersonVo(name, hp, company);
		System.out.println(personVo);
		
		return "/WEB-INF/views/write.jsp";
	}
	*/
	
	
	/*
	 // PathVariable
	@RequestMapping( value="/board/read/{no}", method= {RequestMethod.GET, RequestMethod.POST} )
	public String read(@PathVariable("no") int boardNo) {
			System.out.println("PathVariable [read]");
			System.out.println(boardNo);
			// localhost:8088/phonebook4/board/read/1 --> // boardNo = 1
		return "";
	}
	 */
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="/test")
	public String test() {
		System.out.println("test");
		return "/WEB-INF/views/test.jsp";
	}
}
