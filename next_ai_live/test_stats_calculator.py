from utils import stats_calculator

def test_average():
  assert stats_calculator.average(1, 3) == 2
  assert stats_calculator.average(1, 3, 5) == 3