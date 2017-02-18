
package interceptors;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import beans.User;

public class LoginCheckInterceptor implements HandlerInterceptor {
	private static final String USER_SESSION_ATTRIBUTE_NAME = "user";

	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse resp, Object obj, Exception ex)
			throws Exception {
		/* Nothing needed to be implemented here for now */
	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object obj, ModelAndView modelAndView)
			throws Exception {
		/* Nothing needed to be implemented here for now */
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object obj) throws Exception {
		User user = (User) req.getSession().getAttribute(USER_SESSION_ATTRIBUTE_NAME);
		if (Objects.isNull(user) && !req.getServletPath().contains("/login")) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return false;
		}
		return true;
	}
}
