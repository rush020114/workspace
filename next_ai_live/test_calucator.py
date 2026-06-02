import utils.calculator as calculator
import pytest

def test_add():
  assert calculator.add(1, 2) == 3
  assert calculator.add(2, 5) == 7

def test_mulitply():
  assert calculator.multiply(1, 2) == 2
  assert calculator.multiply(2, 5) == 10

def test_subtract():
  assert calculator.subtract(11, 2) == 9
  assert calculator.subtract(7, 5) == 2

def test_divide():
  assert calculator.divide(4, 2) == 2
  with pytest.raises(ValueError, match="안 돼"):
        calculator.divide(2, 0)