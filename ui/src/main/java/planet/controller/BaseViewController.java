package planet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Base view planet.controller in order to easily map other view controllers
 * on the /app path.
 * <p>
 * All REST controllers should extend this planet.controller.
 */

@Controller
@RequestMapping(value = "/app")
public class BaseViewController {
}