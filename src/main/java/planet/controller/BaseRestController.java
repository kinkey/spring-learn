package planet.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Base rest controller in order to easily map other rest controllers
 * on the /api path.
 * <p>
 * All REST controllers should extend this controller.
 */

@RestController
@RequestMapping(value = "/api")
public class BaseRestController {
}