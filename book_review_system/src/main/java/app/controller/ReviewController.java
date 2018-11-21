package app.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import app.dto.ReviewInfo;
import app.helper.SendNotification;

@Controller
public class ReviewController extends BaseController {
	private static final Logger logger = Logger.getLogger(ReviewController.class);

	@RequestMapping(value = "/books/{bookId}/reviews/add", method = RequestMethod.POST)
	public ModelAndView AddReview(@ModelAttribute("reviewInfo") ReviewInfo reviewInfo,
			@PathVariable("bookId") int bookId) {
		if (reviewInfo.getId() == 0) {
			reviewService.createReview(reviewInfo, bookId, currentUser().getId());
			ReviewInfo reInfo = reviewService.findUserRivew(currentUser().getId(), bookId);
			activityService.saveReviewActivity(reInfo, currentUser().getId());
		} else {
			reviewService.updateReview(reviewInfo);
		}
		return new ModelAndView("redirect:/books/" + bookId);
	}

	@RequestMapping(value = "/review")
	public ModelAndView redirectAddReview(@RequestParam(value = "idBook", required = false) Integer idBook) {
		logger.info("id book" + idBook);
		int idUser = currentUser().getId();
		logger.info("id User" + idUser);
		ReviewInfo reviewInfo = reviewService.findUserRivew(idUser, idBook);
		ModelAndView modelAndView = new ModelAndView("addReview");
		modelAndView.addObject("reviewInfo", reviewInfo);
		modelAndView.addObject("idBook", idBook);
		modelAndView.addObject("titles", bookService.getListTitle());
		modelAndView.addObject("categories", categoryService.categoryName());
		if (reviewInfo.getContent() == null) {
			modelAndView.addObject("hidden", 1);
			modelAndView.addObject("idReview", 0);
		} else {
			modelAndView.addObject("hidden", 2);
			modelAndView.addObject("idReview", reviewInfo.getId());
		}
		return modelAndView;
	}
}
