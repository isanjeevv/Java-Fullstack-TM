import React from 'react';
import ReactDOM from 'react-dom/client';

function EvenNumber(props) {
	return <h1>{props.a} EvenNumber!</h1>;
}
function OddNumber() {
	return <h1>OddNumber!</h1>;
}

function CheckNumber(props) {
  const isNum = props.num;
  if (isNum%2==0) {
    return <EvenNumber a={isNum}/>;
  }
  return <OddNumber/>;
}

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(<CheckNumber num="90" />);
