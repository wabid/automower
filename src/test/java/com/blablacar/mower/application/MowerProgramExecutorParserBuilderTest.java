package com.blablacar.mower.application;

import com.blablacar.mower.domain.mower.*;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by wassim on 02/12/2019.
 */
public class MowerProgramExecutorParserBuilderTest {

    private MowerProgramParserBuilder sut = new MowerProgramParserBuilder();

    @Test
    public void testBuildLawn() throws Exception {
        // given
        String line = "464 96";
        // when
        Lawn lawn = sut.buildLawn(line, 1);
        // then
        assertThat(lawn.getUpperRightCorner()).isEqualTo(
            new UpperRightCorner(464, 96)
        );
    }

    @Test
    public void testBuildMower() throws Exception {
        // given
        String line = "1 2 N";
        // when
        Mower mower = sut.buildMower(line, new Lawn(5, 5), 1);
        // then
        assertThat(mower.getPosition()).isEqualTo(
            new Position(1, 2));
        assertThat(mower.getOrientation()).isEqualTo(
            Orientation.N);
    }

    @Test
    public void testBuildInstructions() throws Exception {
        // given
        String line = "LFLFLFLFF";
        // when
        String instructions = sut.buildInstructions(line, 1);
        // then
        assertThat(instructions).isEqualTo(line);
    }

}