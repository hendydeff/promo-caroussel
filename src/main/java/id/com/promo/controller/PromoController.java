package id.com.promo.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import id.com.promo.entity.ModulePromo;
import id.com.promo.repository.ModulePromoRepository;

@RestController
public class PromoController {
	
	@Autowired
	ModulePromoRepository modulePromoRepository;

	@ResponseBody
	@RequestMapping(value = "/promo", method = RequestMethod.GET)
	public ResponseEntity<?> getPromoCaroussel(@RequestParam(required = false) Integer userID) {
		Optional<List<ModulePromo>> lists = modulePromoRepository.findModulePromoByGroupId(userID);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode arrayNode = mapper.valueToTree(lists);
		JsonNode result = mapper.createObjectNode().set("modules", arrayNode);
		return ResponseEntity.ok(result);
	}
}
