package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import app.dto.UserInfo;
import app.service.ActivityService;
import app.service.BookService;
import app.service.CategoryService;
import app.service.CommentService;
import app.service.FollowService;
import app.service.LoginService;
import app.service.MarkService;
import app.service.NotificationService;
import app.service.RequestService;
import app.service.ReviewService;
import app.service.RoleService;
import app.service.UserService;

public class BaseController {
	@Autowired
	protected UserService userService;
	@Autowired
	protected ActivityService activityService;
	@Autowired
	protected BookService bookService;
	@Autowired
	protected CategoryService categoryService;
	@Autowired
	protected FollowService followService;
	@Autowired
	protected LoginService loginService;
	@Autowired
	protected ReviewService reviewService;
	@Autowired
	protected RoleService roleService;
	@Autowired
	protected CommentService commentService;
	@Autowired 
	protected MarkService  markService;
	@Autowired
	protected RequestService requestService;
	@Autowired
	protected NotificationService notificationService;
	@Autowired
	protected ReloadableResourceBundleMessageSource messageSource;

	protected UserInfo currentUser() {
		try {
			return userService.findUserInfoByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		} catch (Exception e) {
			return null;
		}
	}

}
