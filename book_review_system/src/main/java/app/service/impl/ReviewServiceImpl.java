package app.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import app.dto.FollowInfo;
import app.dto.ReviewInfo;
import app.helper.SendNotification;
import app.model.Follow;
import app.model.Notification;
import app.model.Review;
import app.service.ReviewService;

public class ReviewServiceImpl extends BaseServiceImpl implements ReviewService {
	private static final Logger logger = Logger.getLogger(ReviewServiceImpl.class);

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private SendNotification sendNotification;

	@Override
	public ReviewInfo createReview(ReviewInfo entity, int bookId, int userId) {
		try {
			Review review = new Review();
			review.setNumberOfStar(entity.getNumberOfStar());
			review.setContent(entity.getContent());
			review.setCreatedAt(new Date());
			review.setBook(getBookDAO().findByIdLock(bookId, false));
			review.setUser(getUserDAO().findByIdLock(userId, false));

			ReviewInfo reviewInfo = ConvertModelToBean.mapReviewToReviewInfo(getReviewDAO().saveOrUpdate(review));
			// add notification
			Notification notification = new Notification();
			notification.setUser(review.getUser());
			notification.setReview(review);
			notification.setContent(messageSource.getMessage("review.new",
					new Object[] { review.getUser().getFullName(), "created", review.getCreatedAt().toString() },
					Locale.US));
			notification.setCreatedAt(new Date());
			getNotificationDAO().saveOrUpdate(notification);
			List<FollowInfo> followInfos = new ArrayList<>();
			List<Follow> fList = getFollowDAO().getFollowsByFollowed(userId);
			for (Follow f : fList) {
				followInfos.add(ConvertModelToBean.mapFollowToFollowInfo(f));
			}
			sendNotification.send(ConvertModelToBean.toNotificationInfo(notification), followInfos);
			return reviewInfo;

		} catch (Exception e) {
			logger.error(e);
			throw e;
		}

	}

	@Override
	public ReviewInfo updateReview(ReviewInfo entity) {
		try {
			Review review = getReviewDAO().findById(entity.getId());
			review.setNumberOfStar(entity.getNumberOfStar());
			review.setContent(entity.getContent());
			review.setCreatedAt(entity.getCreatedAt());
			return ConvertModelToBean.mapReviewToReviewInfo(getReviewDAO().saveOrUpdate(review));

		} catch (Exception e) {
			logger.error(e);
			throw e;
		}

	}

	@Override
	public List<Review> loadReviews() {
		try {
			return reviewDAO.loadReivews();
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	@Override
	public List<ReviewInfo> loadReviewsForBook(int book_id) {
		try {
			return ConvertModelToBean.mapReviewToReviewsInf(reviewDAO.loadReviewsForBook(book_id));
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	@Override
	public ReviewInfo findById(Serializable key, boolean lock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(ReviewInfo entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ReviewInfo findUserRivew(Integer userId, Integer bookId) {
		try {
			List<Review> reviews = reviewDAO.loadReviewsForBook(bookId);
			for (Review review : reviews) {
				if (review.getUser().getId() == userId) {
					return ConvertModelToBean.mapReviewToReviewInfo(review);
				}
			}
			ReviewInfo reviewF = new ReviewInfo();
			return reviewF;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}

	}

	@Override
	public ReviewInfo saveOrUpdate(ReviewInfo entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
