import React from 'react'

const TodoList = () => {
  const [todos, setTodos] = useState([]);
  const [filter, setFilter] = useState('all');

  // 함수 저장
  const addTodo = useCallback((text) => {
    setTodos([...todos, { id: Date.now(), text }]);
  }, [todos]);

  // 계산 결과 저장
  const filteredTodos = useMemo(() => {
    console.log('필터링 중...');
    if (filter === 'completed') {
      return todos.filter(todo => todo.completed);
    }
    return todos;
  }, [todos, filter]);

  return (
    <div>
      <TodoInput onAdd={addTodo} />
      <TodoFilter onChange={setFilter} />
      {filteredTodos.map(todo => <Todo key={todo.id} {...todo} />)}
    </div>
  );
}

export default TodoList