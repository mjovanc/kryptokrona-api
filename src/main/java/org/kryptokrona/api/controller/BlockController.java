package org.kryptokrona.api.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.kryptokrona.api.controller.BlockController.VERSION;

/**
 * Block Controller.
 *
 * @author Marcus Cvjeticanin
 */
@RestController
@CrossOrigin(origins="*")
@RequestMapping("api/v" + VERSION + "/block")
@Tag(name = "blocks", description = "Set of endpoints to get data of blocks.")
public class BlockController {

    static final String VERSION = "1";

    private static final Logger logger = LoggerFactory.getLogger(HashrateController.class);

}
